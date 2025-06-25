package com.example.iDemoService.validator;

import com.example.iDemoService.api.v1.dto.PersonDto;
import org.springframework.stereotype.Service;

@Service
public class PersonValidator {

    public boolean validatePerson(PersonDto personDto) {


        return true;
    }

}
