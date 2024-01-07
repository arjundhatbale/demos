package com.main.entity.onetomany;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="teacher")
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="teacherStdClassNo")
	private Integer teacherStdClassNo;
	private String teacherName;
	private Integer teacherAge;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="teacherStdClassNo")
	private List<Subject> subject;

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(Integer teacherStdClassNo, String teacherName, Integer teacherAge, List<Subject> subject) {
		super();
		this.teacherStdClassNo = teacherStdClassNo;
		this.teacherName = teacherName;
		this.teacherAge = teacherAge;
		this.subject = subject;
	}

	public Integer getTeacherStdClassNo() {
		return teacherStdClassNo;
	}

	public void setTeacherStdClassNo(Integer teacherStdClassNo) {
		this.teacherStdClassNo = teacherStdClassNo;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Integer getTeacherAge() {
		return teacherAge;
	}

	public void setTeacherAge(Integer teacherAge) {
		this.teacherAge = teacherAge;
	}

	public List<Subject> getSubject() {
		return subject;
	}

	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Teacher [teacherStdClassNo=" + teacherStdClassNo + ", teacherName=" + teacherName + ", teacherAge="
				+ teacherAge + ", subject=" + subject + "]";
	}

	 
	
}
