package com.example.schoolrecords.service;

import java.util.List;
import java.util.Optional;

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
		Optional<Student> s =studentRepository.findById(id);
		Student student = s.isPresent() ? s.get() : new Student();
		if(s.isPresent()) {
			studentRepository.deleteById(id);
			System.out.println("Student Details Deleted: " + id);
		}else {
			System.out.println("Student Details does not exists: " + id);
		}
		return student;
	}
	
	public Student addSubjectToStudent(Integer id, Subject subject) {
		Optional<Student> s =studentRepository.findById(id);
		Student student = s.isPresent() ? s.get() : new Student();
		if(s.isPresent()) {
			List<Subject> ar = student.getSubjects();
			ar.add(subject);
			student.setSubjects(ar);
			studentRepository.save(student);
			student = studentRepository.findById(id).get();
			System.out.println("Student Details Updated");
		}else {
			System.out.println("Student Not Found");
		}
		return student;
	}
}
