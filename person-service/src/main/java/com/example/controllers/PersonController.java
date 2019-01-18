package com.example.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Person;

@RestController
@RequestMapping("/")
public class PersonController {

	@RequestMapping("/people")
	public List<Person> getPeople(){
		List<Person> people = Arrays.asList(
				new Person(1, "Pedro", "00000000191"),
				new Person(2, "Tiago", "12312345684"),
				new Person(3, "João", "54687876542"));
		return people;
	}
}
