package com.example.iDemoService.api.v1.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PersonDto {

    private int id;
    private String name;
    private String birthDay;
    private PersonDto parent1;
    private PersonDto parent2;
    private PersonDto partner;
    private List<PersonDto> children;
}
