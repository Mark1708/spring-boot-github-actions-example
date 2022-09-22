package com.example.springbootapp.person;

import com.example.springbootapp.utils.PersonServiceUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
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
class PersonServiceTest {

	@MockBean
	private PersonRepository repo;

	@Autowired
	private PersonService service;

	private List<Person> persons;

	@BeforeEach
	void init() {
		PersonServiceUtils.initData();
		persons = new ArrayList<>();
		persons.add(PERSON_1);
		persons.add(PERSON_2);
		Mockito.when(repo.findPersonById(1L)).thenReturn(Optional.of(PERSON_1));
		Mockito.when(repo.findPersonById(2L)).thenReturn(Optional.empty());
	}

	@Test
	void getAllPerson() {
		Mockito.when(repo.findAll()).thenReturn(persons);
		List<Person> result = service.getAllPerson();
		assertEquals(2, result.size());
		assertTrue(result.contains(PERSON_1));
		assertTrue(result.contains(PERSON_2));
	}

	@Test
	void getPerson() {
		assertEquals(PERSON_1, service.getPerson(1L));
	}

	@Test
	void getPersonException() {
		Mockito.when(repo.findPersonById(2L)).thenReturn(Optional.empty());
		assertThrows(NotFoundException.class, () -> service.getPerson(2L));
	}

}