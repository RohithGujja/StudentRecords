package com.example.schoolrecords.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;
	
	@NotNull(message = "Name cannot be Empty")
	private String studentName;
	
	@NotNull(message = "Age cannot be Empty")
	@Positive(message = "Age should be Positive")
	private String age;
	
	@NotNull(message = "Class cannot be Empty")
	@Positive(message = "Class should be Positive")
	private Integer studentClass;
	
	@Email(message = "Invalid Email Address")
	private String email;

	//@OneToMany(cascade = CascadeType.ALL,targetEntity = Subject.class)
	//@JoinColumn(name = "student_id")
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "student")
	@JsonManagedReference
	private List<Subject> subjects;

	public Student() {
		super();
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Integer getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(Integer studentClass) {
		this.studentClass = studentClass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", age=" + age + ", studentClass="
				+ studentClass + ", email=" + email + ", subjects=" + subjects + "]";
	}
	
}
