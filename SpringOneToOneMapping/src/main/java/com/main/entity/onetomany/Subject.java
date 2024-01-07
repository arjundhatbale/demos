package com.main.entity.onetomany;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="subject")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="subjectCode")
	private Integer subjectCode;
	private String subjectName;
	private Float subjectMarks;
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Subject(Integer subjectCode, String subjectName, Float subjectMarks) {
		super();
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.subjectMarks = subjectMarks;
	}
	public Integer getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(Integer subjectCode) {
		this.subjectCode = subjectCode;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public Float getSubjectMarks() {
		return subjectMarks;
	}
	public void setSubjectMarks(Float subjectMarks) {
		this.subjectMarks = subjectMarks;
	}
	@Override
	public String toString() {
		return "Subject [subjectCode=" + subjectCode + ", subjectName=" + subjectName + ", subjectMarks=" + subjectMarks
				+ "]";
	}
	
	
	
}
