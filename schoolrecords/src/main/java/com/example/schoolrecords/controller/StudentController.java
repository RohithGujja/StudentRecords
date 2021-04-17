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

import com.example.schoolrecords.model.Student;
import com.example.schoolrecords.model.Subject;
import com.example.schoolrecords.service.StudentService;

@RestController
@RequestMapping(path = "/StudentRecords")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping(path = "/addStudent")
	public Student addStudent(@Valid @RequestBody Student student) {
		return studentService.addStudent(student);
	}
	
	@GetMapping(path = "/getStudent/{student_id}")
	public Student findStudent(@PathVariable(name = "student_id") Integer id) {
		return studentService.findStudent(id);
	}
	
	@DeleteMapping(path = "/deleteStudent/{student_id}")
	public Student deleteStudent(@PathVariable(name = "student_id") Integer id) {
		return studentService.deleteStudent(id);
	}
	
	@PutMapping(path = "/updateStudent/{student_id}")
	public Student addSubjectToStudent(@PathVariable(name = "student_id") Integer id, @Valid @RequestBody Subject subject) {
		return studentService.addSubjectToStudent(id, subject);
	}

}
