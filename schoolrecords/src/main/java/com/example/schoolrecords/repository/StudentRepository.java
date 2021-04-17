package com.example.schoolrecords.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.schoolrecords.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

}
