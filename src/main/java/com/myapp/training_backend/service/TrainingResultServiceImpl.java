package com.myapp.training_backend.service;

import com.myapp.training_backend.dto.RequestDto;
import com.myapp.training_backend.dto.TrainingFieldDto;
import com.myapp.training_backend.dto.request.TrainingResultRequestDto;
import com.myapp.training_backend.dto.response.TrainingResultResponseDto;
import com.myapp.training_backend.entity.TrainingResult;
import com.myapp.training_backend.repository.TrainingResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingResultServiceImpl implements TrainingResultService{

    private final TrainingResultRepository trainingResultRepository;
    private final TrainingCoursesService trainingCoursesService;


    @Override
    public String createListCoursesForNewEmployees(TrainingResultRequestDto trainingResultRequestDto) {
        RequestDto requestDto = new RequestDto(trainingResultRequestDto.actualDeptRootId().intValue(),
                trainingResultRequestDto.appointId().intValue());
        List<TrainingFieldDto> trainingFieldDtoList = trainingCoursesService.getTrainingFieldIds(requestDto);

        int cardId = trainingResultRequestDto.cardId().intValue();
        List<TrainingResult> trainingResultList = trainingFieldDtoList.stream()
                .map((el) -> createTrainingResult(el, cardId))
                .toList();
        trainingResultRepository.saveAll(trainingResultList);
        return "In table 'training_results' created " + trainingResultList.size()
                + " new records for new employee with cardId: " + cardId;
    }

    private TrainingResult createTrainingResult(TrainingFieldDto el, int cardId) {
        TrainingResult trainingResult = new TrainingResult();
        trainingResult.setCardId(cardId);
        trainingResult.setTrainingField(el.trainingFieldId());
        return trainingResult;
    }
}
