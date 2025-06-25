package com.example.iDemoService.validator;

import com.example.iDemoService.domain.PersonEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;
import java.util.function.Predicate;

@Service
public class PersonValidator {

    Predicate<PersonEntity> personHasPartner = e -> e.getPartner() != null;
    Predicate<PersonEntity> person3Children = e -> (long) e.getChildren().size() == 3;
    Predicate<PersonEntity> childrenHaveCorrectParents = e -> e.getChildren().stream()
            .filter(child -> child.getParent1().getId() == e.getId() || child.getParent2().getId() == e.getId())
            .isParallel();
    Predicate<PersonEntity> childUnderAge = e -> {
        long count = 0L;
        for (PersonEntity child : e.getChildren()) {
            if (child.getBirthDay()
                    .isBefore(ChronoLocalDate.from(Instant.now().minus(18, ChronoUnit.YEARS)))) {
                count++;
            }
        }
        return count > 0;
    };

    public boolean validatePerson(PersonEntity personEntity) {
        Predicate<PersonEntity> complexFilter = personHasPartner.and(person3Children.and(childrenHaveCorrectParents.and(childUnderAge)));
        return complexFilter.test(personEntity);
    }

}
