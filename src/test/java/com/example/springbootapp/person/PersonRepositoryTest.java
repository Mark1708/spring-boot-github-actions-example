package com.example.springbootapp.person;

import com.example.springbootapp.utils.PersonServiceUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.springbootapp.utils.PersonServiceUtils.PERSON_1;
import static com.example.springbootapp.utils.PersonServiceUtils.PERSON_2;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "classpath:application.properties")
class PersonRepositoryTest {

    @Autowired
    private PersonRepository repo;

    private List<Person> persons;

    @BeforeEach
    void init() {
        PersonServiceUtils.initData();
        persons = new ArrayList<>();
        persons.add(PERSON_1);
        persons.add(PERSON_2);
        repo.saveAll(persons);
    }

    @Test
    void findAll() {
        List<Person> all = repo.findAll();
        assertEquals(2, all.size());
        assertTrue(all.contains(PERSON_1));
        assertTrue(all.contains(PERSON_2));
    }

    @Test
    void findPersonById() {
        Optional<Person> personById = repo.findPersonById(PERSON_1.getId());
        assertTrue(personById.isPresent());
        assertEquals(PERSON_1, personById.get());
    }

    @Test
    void findPersonByIdException() {
        Optional<Person> personById = repo.findPersonById(3L);
        assertFalse(personById.isPresent());
    }
}