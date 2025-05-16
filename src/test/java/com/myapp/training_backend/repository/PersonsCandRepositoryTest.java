package com.myapp.training_backend.repository;

import com.myapp.training_backend.entity.PersonsCand;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class PersonsCandRepositoryTest {

    @Autowired
    private PersonsCandRepository personsCandRepository;

    @BeforeEach
    public void setUp(){
        PersonsCand personsCand1 = PersonsCand.builder()
                .id(2345)
                .empId(8888L)
                .lName("TestLastName")
                .dFrom(LocalDate.of(2020, 5, 23))
                .appointId(3333)
                .appointName("строитель кораблей")
                .categId(44)
                .categName("вспомогательные рабочие")
                .dIn(LocalDate.of(2025, 1, 12))
                .dOut(LocalDate.of(2020,6,12))
                .deptId(1111)
                .deptName("021 паросиловой цех")
                .build();
        PersonsCand personsCand2 = PersonsCand.builder()
                .id(2346)
                .empId(8188L)
                .lName("TestLastName2")
                .dFrom(LocalDate.of(2020, 5, 24))
                .appointId(3333)
                .appointName("строитель кораблей")
                .categId(44)
                .categName("вспомогательные рабочие")
                .dIn(LocalDate.of(2025, 1, 12))
                .dOut(LocalDate.ofEpochDay(2020-6-12))
                .deptId(1111)
                .deptName("021 паросиловой цех")
                .build();
        personsCandRepository.save(personsCand1);
        personsCandRepository.save(personsCand2);
    }

    @Test
    void PersonsCandRepository_FindByDateInToday_ReturnList() {
        List<PersonsCand> personsCandList = personsCandRepository
                .findByDateInToday(LocalDate.of(2025, 1, 12));

        Assertions.assertThat(personsCandList).isNotNull();
        Assertions.assertThat(personsCandList.size()).isEqualTo(2);
        Assertions.assertThat(personsCandList.get(0).getId()).isEqualTo(2345);
    }
}