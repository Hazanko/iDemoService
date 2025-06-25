package com.example.iDemoService.repository;

import com.example.iDemoService.domain.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {

    PersonEntity findbyId(int id);
}
