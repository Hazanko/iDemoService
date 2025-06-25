package com.example.iDemoService.api.v1;

import com.example.iDemoService.api.v1.dto.PersonDto;
import com.example.iDemoService.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class PersonControllerTest {

    private PersonDto father;
    private PersonDto mother;
    private PersonDto partner;
    private PersonDto child1;
    private PersonDto child2;
    private PersonDto adult;

    @InjectMocks
    private PersonService personService;

    @BeforeEach
    public void setup() {
        father = PersonDto.builder()
                .id(1)
                .name("Henk")
                .birthDay("1770-12-12")
                .build();

        mother = PersonDto.builder()
                .id(2)
                .name("Maria")
                .birthDay("1775-12-12")
                .build();

        partner = PersonDto.builder()
                .id(99)
                .name("Sarah")
                .birthDay("1815-12-12")
                .build();

        child1 = PersonDto.builder()
                .id(77)
                .name("Reginald")
                .birthDay("1840-12-12")
                .build();

        child2 = PersonDto.builder()
                .id(78)
                .name("Annie")
                .birthDay("1840-12-12")
                .build();

        adult = PersonDto.builder()
                .id(42)
                .name("Ada Lovelace")
                .birthDay("1815-12-10")
                .parent1(father)
                .parent2(mother)
                .partner(partner)
                .children(List.of(
                        child1,
                        child2
                ))
                .build();

    }

    @Test
    void createOrUpdatePerson() {


    }
}