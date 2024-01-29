package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Item;

public interface ItemRepo extends JpaRepository<Item, Integer> {

}
