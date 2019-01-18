package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.ContactList;

@RestController
@RequestMapping("/")
public class ContactController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Environment env;
	
	@RequestMapping("/")
	public String home() {
		return "Contact service rodando na porta: " + env.getProperty("local.server.port");
	}
	
	@RequestMapping("/{id}")
	public ContactList getGallery(@PathVariable final int id) {
		ContactList contactList = new ContactList();
		contactList.setId(id);
		
		List<Object> people = restTemplate.getForObject("http://person-service/people/", List.class);
		contactList.setContactList(people);
	
		return contactList;
	}
}
