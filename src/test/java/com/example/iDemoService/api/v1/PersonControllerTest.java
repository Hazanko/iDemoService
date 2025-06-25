package com.example.iDemoService.api.v1;

import com.example.iDemoService.api.v1.dto.PersonDto;
import com.example.iDemoService.validator.PersonValidator;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class PersonControllerTest {

    private PersonDto adult;

    private static final String TEST_JSON = """
            {
              "id":42,
              "name":"Ada Lovelace",
              "birthDate":"1815-12-10",
              "parent1":{"id":1},
              "parent2":{"id":2},
              "partner":{"id":99},
              "children":[{"id":77},{"id":78}]
            }
            """;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private PersonValidator personValidator;

    @InjectMocks
    private PersonController personController;

    @BeforeEach
    public void setup() {
        PersonDto father = PersonDto.builder()
                .id(1)
                .name("Henk")
                .birthDay("1770-12-12")
                .build();

        PersonDto mother = PersonDto.builder()
                .id(2)
                .name("Maria")
                .birthDay("1775-12-12")
                .build();

        PersonDto partner = PersonDto.builder()
                .id(99)
                .name("Sarah")
                .birthDay("1815-12-12")
                .build();

        PersonDto child1 = PersonDto.builder()
                .id(77)
                .name("Reginald")
                .birthDay("1840-12-12")
                .build();

        PersonDto child2 = PersonDto.builder()
                .id(78)
                .name("Annie")
                .birthDay("1840-12-12")
                .build();

        adult = PersonDto.builder()
                .id(42)
                .name("Ada Lovelace")
                .birthDay("1815-12-10")
                .parent1(father)
                .parent2(mother)
                .partner(partner)
                .children(List.of(
                        child1,
                        child2
                ))
                .build();

    }

    @Test
    void createOrUpdatePerson_ShouldResultIn444Error() throws Exception {
        //arrange
        when(personValidator.validatePerson(any())).thenReturn(false);

        //act
        val result = mockMvc.perform(post("/api/v1/people")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TEST_JSON)
        );

        //assert
        result.andExpect(status().is4xxClientError());
    }
}