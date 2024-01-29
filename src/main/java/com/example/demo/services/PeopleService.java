package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.domain.People;
import com.example.demo.repos.PeopleRepo;

@Service
public class PeopleService {
	private PeopleRepo repo;

	public PeopleService(PeopleRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<People> createPerson(People newPeople) {
		People created = this.repo.save(newPeople);
		return new ResponseEntity<People>(created, HttpStatus.CREATED);
	}

	public List<People> readAll() {
		return this.repo.findAll();
	}

	public ResponseEntity<People> updatePeople(int id, People newPeople) {
		Optional<People> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<People>(HttpStatus.NOT_FOUND);
		}

		People existing = found.get();

		if (newPeople.getName() != null) {
			existing.setName(newPeople.getName());
		}

		People updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);
	}

	public ResponseEntity<People> read(int id) {
		Optional<People> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return ResponseEntity.ok(found.get());
	}

	public boolean delete(int id) {
		this.repo.deleteById(id);

		return !this.repo.existsById(id);
	}
}
