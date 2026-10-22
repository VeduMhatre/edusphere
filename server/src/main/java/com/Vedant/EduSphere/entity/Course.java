package com.Vedant.EduSphere.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String courseName;
	private String courseCode;
	private String courseInstructor;
	private Integer duration;
	private BigDecimal fees;
	private String status;

	public Course(){}
	public Course(Long id, String courseName, String courseCode, String courseInstructor, Integer duration, BigDecimal fees, String status){
		this.id=id;
		this.courseName=courseName;
		this.courseCode=courseCode;
		this.courseInstructor=courseInstructor;
		this.duration=duration;
		this.fees=fees;
		this.status=status;
	}
	
	public Long getId(){return id;}
	public String getCourseName(){return courseName;}
	public String getCourseCode(){return courseCode;}
	public String getCourseInstructor(){return courseInstructor;}
	public Integer getDuration(){return duration;}
	public BigDecimal getFees(){return fees;}
	public String getStatus(){return status;}

	public void setId(Long id){this.id=id;}
	public void setCourseName(String courseName){this.courseName=courseName;}
	public void setCourseCode(String courseCode){this.courseCode=courseCode;}
	public void setCourseInstructor(String courseInstructor){this.courseInstructor=courseInstructor;}
	public void setDuration(Integer duration){this.duration=duration;}
	public void setFees(BigDecimal fees){this.fees=fees;}
	public void setStatus(String status){this.status=status;}

}
