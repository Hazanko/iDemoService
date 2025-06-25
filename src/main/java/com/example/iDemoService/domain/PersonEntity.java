package com.example.iDemoService.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // needed for JPA/Hibernate
@AllArgsConstructor(access = AccessLevel.PROTECTED) // needed for @Builder
@Entity(name = "person")
@Builder
@Table(name = "person")
public class PersonEntity {

    @Id
    private int id;

    private String name;

    private LocalDate birthDay;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_1")
    private PersonEntity parent1;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_2")
    private PersonEntity parent2;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "partner")
    private PersonEntity partner;

    @OneToMany(mappedBy = "person")
    private List<PersonEntity> children;

}

