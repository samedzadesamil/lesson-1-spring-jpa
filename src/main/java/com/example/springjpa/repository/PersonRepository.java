package com.example.springjpa.repository;

import com.example.springjpa.entitiy.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
Person getPersonById(long id);
}
