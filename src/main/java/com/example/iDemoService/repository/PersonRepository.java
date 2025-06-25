package com.example.iDemoService.repository;

import com.example.iDemoService.domain.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {

    Optional<PersonEntity> findbyId(int id);
}
