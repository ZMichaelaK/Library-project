package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.People;

public interface PeopleRepo extends JpaRepository<People, Integer> {

}
