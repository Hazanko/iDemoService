package com.example.iDemoService.service;

import com.example.iDemoService.api.v1.dto.PersonDto;
import com.example.iDemoService.domain.PersonEntity;
import com.example.iDemoService.repository.PersonRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public PersonEntity addOrUpdatePerson(PersonDto personDto) {
        val person = personRepository.findbyId(personDto.getId());
        if (person.isEmpty()) {
            return addPerson(personDto);
        } else {
            return updatePerson(person.get(), personDto);
        }
    }

    public PersonEntity addPerson(PersonDto personDto) {
        val personEntity = PersonEntity.builder()
                .name(personDto.getName())
                .birthDay(LocalDate.parse(personDto.getBirthDay()))
                .build();
        return personRepository.save(personEntity);
    }

    public PersonEntity updatePerson(PersonEntity entity, PersonDto dto) {
        entity.setName(dto.getName());
        entity.setBirthDay(LocalDate.parse(dto.getBirthDay()));
        return personRepository.save(entity);
    }

}
