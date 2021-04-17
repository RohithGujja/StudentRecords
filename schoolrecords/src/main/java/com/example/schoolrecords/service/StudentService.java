package com.example.schoolrecords.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.schoolrecords.model.Student;
import com.example.schoolrecords.model.Subject;
import com.example.schoolrecords.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Student findStudent(Integer id) {
		return studentRepository.findById(id).get();
	}

	public Student deleteStudent(Integer id) {
		Student s =studentRepository.findById(id).get();
		if(null != s) {
			studentRepository.deleteById(id);
			System.out.println("Student Details Deleted: " + id);
		}else {
			System.out.println("Student Details does not exists: " + id);
		}
		return s;
	}
	
	public Student addSubjectToStudent(Integer id, Subject subject) {
		Student s =studentRepository.findById(id).get();
		if(null != s) {
			List<Subject> ar = s.getSubjects();
			ar.add(subject);
			s.setSubjects(ar);
			studentRepository.save(s);
			System.out.println("Student Details Updated");
		}else {
			System.out.println("Student Not Found");
		}
		s = studentRepository.findById(id).get();
		return s;
	}
}
