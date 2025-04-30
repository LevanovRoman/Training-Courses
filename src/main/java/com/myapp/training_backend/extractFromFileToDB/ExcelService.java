package com.myapp.training_backend.extractFromFileToDB;

import com.myapp.training_backend.entity.Department;
import com.myapp.training_backend.entity.Position;
import com.myapp.training_backend.entity.TrainingCourse;
import com.myapp.training_backend.entity.TrainingField;
import com.myapp.training_backend.repository.DepartmentRepository;
import com.myapp.training_backend.repository.PositionRepository;
import com.myapp.training_backend.repository.TrainingCourseRepository;
import com.myapp.training_backend.repository.TrainingFieldRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ExcelService {

    @Value("${project.departmentId}")
    int departmentId;

    private static final Logger logger = LoggerFactory.getLogger(ExcelService.class);

    private final TrainingFieldRepository trainingFieldRepository;
    private final PositionRepository handbookPositionRepository;
    private final TrainingCourseRepository trainingCoursesRepository;
    private final DepartmentRepository handbookDepartmentRepository;

    public ExcelService(TrainingFieldRepository trainingFieldRepository, PositionRepository handbookPositionRepository, TrainingCourseRepository trainingCoursesRepository, DepartmentRepository handbookDepartmentRepository) {
        this.trainingFieldRepository = trainingFieldRepository;
        this.handbookPositionRepository = handbookPositionRepository;
        this.trainingCoursesRepository = trainingCoursesRepository;
        this.handbookDepartmentRepository = handbookDepartmentRepository;
    }

    public void processExcelFile(String filePath) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        String currentPosition = null;

        int counter = 1;

        for (Row row : sheet) {
            Cell positionCell = row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            Cell courseCell = row.getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

            String positionStr = cleanString(positionCell.getStringCellValue());
            String courseStr = cleanString(courseCell.getStringCellValue());

            if (!positionStr.isEmpty()) {
                currentPosition = positionStr;
//                System.out.println("currentPosition  " + currentPosition);
            }

            if (currentPosition != null && !courseStr.isEmpty()) {
//                Optional<HandbookPosition> position = handbookPositionRepository.findByNameIgnoreCase(currentPosition);
                List<Position> positionList = handbookPositionRepository.findAllByNameIgnoreCase(currentPosition);
                Position position = positionList.getFirst();
//                System.out.println("PO  " + position.getId());
                List<TrainingField> courseList = trainingFieldRepository.findAllByCourse(courseStr);
                TrainingField course = courseList.getFirst();
//                Optional<TrainingField> course = trainingFieldRepository.findFirstByTitle(courseStr);

//                System.out.println("COU  " + course.getId());

//                System.out.println(position.getId() + ", " + course.getId());
                Department department = handbookDepartmentRepository.findById(departmentId)
                        .orElseThrow(RuntimeException::new);
                Optional<TrainingCourse> existing = trainingCoursesRepository
                        .findByDepartmentAndPositionAndCourse(department, position, course);
                if (existing.isEmpty()){
                    TrainingCourse trainingCoursesList = new TrainingCourse();
                    trainingCoursesList.setDepartment(department);
                    trainingCoursesList.setPosition(position);
                    trainingCoursesList.setCourse(course);
                    TrainingCourse saved = trainingCoursesRepository.save(trainingCoursesList);
                    logger.info("Saved: positionId={}, courseId={}",
                            saved.getPosition().getName(), saved.getCourse().getCourse());
//                    System.out.println(counter);
//                    System.out.println(trainingCoursesList);
                    counter++;
                }
            }
        }
        workbook.close();
        file.close();
    }

    private String cleanString(String input) {
        return input.replaceAll("\\s+", " ").trim().replaceAll("\\d+$", "").trim();
    }
}
