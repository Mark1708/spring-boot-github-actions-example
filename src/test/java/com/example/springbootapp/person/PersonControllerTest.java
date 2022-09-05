package com.example.springbootapp.person;

import static com.example.springbootapp.utils.PersonServiceUtils.PERSON_1;
import static com.example.springbootapp.utils.PersonServiceUtils.PERSON_2;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.springbootapp.utils.PersonServiceUtils;
import org.assertj.core.util.Lists;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PersonController.class)
@TestPropertySource(locations = "classpath:application.properties")
class PersonControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PersonService service;

    private List<Person> persons;

    @BeforeEach
    void init() {
        PersonServiceUtils.initData();
        persons = new ArrayList<>();
        persons.add(PERSON_1);
        persons.add(PERSON_2);
        Mockito.when(service.getAllPerson()).thenReturn(persons);
        Mockito.when(service.getPerson(1L)).thenReturn(PERSON_1);
        Mockito.when(service.getPerson(2L)).thenThrow(NotFoundException.class);

    }

    @Test
    void getAllPersons() throws Exception {
        mockMvc.perform(get("/person"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(2)))
                .andExpect(jsonPath("$[0].name", Matchers.is("Mark")));
    }

    @Test
    void getPerson() throws Exception {
        mockMvc.perform(get("/person/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Mark"));

    }

    @Test
    void getPersonException() throws Exception {
        mockMvc.perform(get("/person/2"))
                .andExpect(status().isNotFound());

    }
}