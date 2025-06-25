package com.example.iDemoService.api.v1;

import com.example.iDemoService.api.v1.dto.PersonDto;
import com.example.iDemoService.service.PersonService;
import com.example.iDemoService.validator.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("PersonV1Controller")
@RequestMapping("/v1")
public class PersonController {

    @Autowired
    private PersonValidator personValidator;

    @Autowired
    private PersonService personService;

    @PostMapping("/people")
    public ResponseEntity<PersonDto> createOrUpdatePerson(
            @RequestBody PersonDto personDto
    ) {
        if (!personValidator.validatePerson(personDto)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); //opted for 404 because there is no 444 status
        }


        return null;
    }

}
