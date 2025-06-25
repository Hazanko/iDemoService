package com.example.iDemoService.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // needed for JPA/Hibernate
@AllArgsConstructor(access = AccessLevel.PROTECTED) // needed for @Builder
@Entity
@Builder
public class PersonEntity {

    @Id
    private int id;
    private String name;
    private LocalDate birthDay;
    private PersonEntity parent1;
    private PersonEntity parent2;
    private PersonEntity partner;
    private List<PersonEntity> children;

}
