package com.example.schoolrecords.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.schoolrecords.model.Subject;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Integer> {

}
