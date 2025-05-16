package com.myapp.training_backend.service;

import com.myapp.training_backend.entity.PersonsCand;
import com.myapp.training_backend.repository.PersonsCandRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonsCandServiceImplTest {

    @Mock
    private PersonsCandRepository personsCandRepository;

    @InjectMocks
    private PersonsCandServiceImpl personsCandService;

    @Test
    void testGetPersonsByToday_ReturnsListOfPersons() {
        // data
        PersonsCand personsCand1 = PersonsCand.builder()
                .id(2345)
                .empId(8888L)
                .lName("TestLastName")
                .appointId(3333)
                .appointName("строитель кораблей")
                .categId(44)
                .categName("вспомогательные рабочие")
                .dIn(LocalDate.ofEpochDay(2013- 7 -22))
                .dOut(LocalDate.ofEpochDay(2020-6-12))
                .deptId(1111)
                .deptName("021 паросиловой цех")
                .build();
        PersonsCand personsCand2 = PersonsCand.builder()
                .id(2346)
                .empId(8188L)
                .lName("TestLastName2")
                .appointId(3333)
                .appointName("строитель кораблей")
                .categId(44)
                .categName("вспомогательные рабочие")
                .dIn(LocalDate.ofEpochDay(2013- 7 -22))
                .dOut(LocalDate.ofEpochDay(2020-6-12))
                .deptId(1111)
                .deptName("021 паросиловой цех")
                .build();
        List<PersonsCand> mockPersonsCandList = List.of(personsCand1, personsCand2);
        // mock
        when(personsCandRepository.findByDateInToday(LocalDate.now())).thenReturn(mockPersonsCandList);
        // call
        List<PersonsCand> result = personsCandService.getPersonsByToday();
        // check
        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result.get(0).getId()).isEqualTo(2345);
        Assertions.assertThat(result.get(1).getId()).isEqualTo(2346);

        verify(personsCandRepository, times(1)).findByDateInToday(LocalDate.now());

    }
}