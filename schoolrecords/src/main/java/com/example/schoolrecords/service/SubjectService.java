package com.example.schoolrecords.service;

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
		Subject s = subjectRepository.findById(id).get();
		if(null != s) {
			subjectRepository.deleteById(id);
			System.out.println("Subject Details Deleted: " + id);
		}else {
			System.out.println("Subject Details does not exists: " + id);
		}
		return s;
	}
	
	public Subject updateGrade(Integer id, Long grade) {
		Subject s = subjectRepository.findById(id).get();
		if(null!=s){
			s.setGrade(grade);
			subjectRepository.save(s);
			System.out.println("Subject Details updated");
			System.out.println(s.toString());
		}else {
			System.out.println("Subject details not found");
		}
		s = subjectRepository.findById(id).get();
		return s;
	}
}
