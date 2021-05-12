package com.example.schoolrecords.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.schoolrecords.service.StudentService;

@RestController
public class StudentDetailsController {
	@Autowired
	StudentService service;
	
	@GetMapping(path = "/getCustomMarks")
	public String getCustomMarks() {
		return "Under Construction";
	}

}
