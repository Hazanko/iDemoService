package com.example.iDemoService.api.v1;

import com.example.iDemoService.api.v1.dto.PersonDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("PersonV1Controller")
@RequestMapping("/v1")
public class PersonController {

    @PostMapping("/people")
    public ResponseEntity<PersonDto> createOrUpdatePerson(
            @RequestBody PersonDto personDto
    ) {
        return null;
    }

}
