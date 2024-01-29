package com.example.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.People;
import com.example.demo.services.PeopleService;

@RestController
@RequestMapping("/people")
public class PeopleController {
	private PeopleService service;

	public PeopleController(PeopleService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<People> createRiver(@RequestBody People newPeople) {
		return this.service.createPerson(newPeople);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<People> getPeople(@PathVariable int id) {
		return this.service.read(id);
	}

	@GetMapping("/get")
	public List<People> getPeople() {
		return this.service.readAll();
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<People> updatePeople(@PathVariable int id, @RequestBody People newPeople) {
		return this.service.updatePeople(id, newPeople);
	}

	@DeleteMapping("/remove/{id}")
	public boolean delete(@PathVariable int id) {
		return this.service.delete(id);
	}
}
