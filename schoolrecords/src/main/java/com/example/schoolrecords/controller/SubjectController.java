package com.example.schoolrecords.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.schoolrecords.model.Subject;
import com.example.schoolrecords.service.SubjectService;

@RestController
@RequestMapping(path = "/StudentRecords")
public class SubjectController {
	
	@Autowired
	SubjectService subjectService;
	
	@PostMapping(path = "/addSubject")
	public Subject addStudent(@Valid @RequestBody Subject subject) {
		return subjectService.addSubject(subject);
	}
	
	@GetMapping(path = "/getSubject/{subject_id}")
	public Subject findStudent(@PathVariable(name = "subject_id") Integer id) {
		return subjectService.findSubject(id);
	}
	
	@DeleteMapping(path = "/deleteSubject/{subject_id}")
	public Subject deleteStudent(@PathVariable(name = "subject_id") Integer id) {
		return subjectService.deleteSubject(id);
	}
	
	@PutMapping(path = "/updateSubject/{subject_id}/{grade}")
	public Subject updateSubject(@PathVariable(name = "subject_id") Integer id,@PathVariable(name = "grade") Long grade) {
		return subjectService.updateGrade(id, grade);
	}

}
