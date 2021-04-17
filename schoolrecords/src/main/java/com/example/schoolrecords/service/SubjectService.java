package com.example.schoolrecords.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.schoolrecords.model.Subject;
import com.example.schoolrecords.repository.SubjectRepository;

@Service
public class SubjectService {
	
	@Autowired
	SubjectRepository subjectRepository;
	
	public Subject addSubject(Subject subject) {
		return subjectRepository.save(subject);
	}
	
	public Subject findSubject(Integer id) {
		return subjectRepository.findById(id).get();
	}
	
	public Subject deleteSubject(Integer id) {
		Optional<Subject> s = subjectRepository.findById(id);
		Subject subject = s.isPresent() ? s.get() : new Subject();
		if(s.isPresent()) {
			subjectRepository.deleteById(id);
			System.out.println("Subject Details Deleted: " + id);
		}else {
			System.out.println("Subject Details does not exists: " + id);
		}
		return subject;
	}
	
	public Subject updateGrade(Integer id, Long grade) {
		Optional<Subject> s = subjectRepository.findById(id);
		Subject subject = s.isPresent() ? s.get() : new Subject();;
		if(s.isPresent()) {
			subject.setGrade(grade);
			subjectRepository.save(subject);
			System.out.println("Subject Details updated");
		}else {
			System.out.println("Subject details not found");
		}
		return subject;
	}
}
