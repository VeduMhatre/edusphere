package com.Vedant.EduSphere.service;

import com.Vedant.EduSphere.entity.Course;
import com.Vedant.EduSphere.repository.CourseRepository;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class CourseService {

	private CourseRepository repo;
	public CourseService(CourseRepository repo){
		this.repo=repo;
	}
	
	public String addCourse(Course c){
		String msg ="";
		
		if(c.getId() != null && repo.existsById(c.getId())){
			msg = c.getId() + "Already Exists";
		}
		else{
			try{
				repo.save(c);
				msg = "Record Created";
			}
			catch(Exception e){
				msg = "Create Issue" + e;
			}
		}
		return msg;
	}

	public List<Course> getCourse(){
		return repo.findAll();
	}

	public String updateCourse(Course c){
		String msg ="";
		try{
			repo.save(c);
			msg = "Record Update";
		}
		catch(Exception e){
			msg = "Update Issue" + e;
		}
		return msg;
	}

	public String deleteCourse(Long id){
		String msg="";
		try{
			repo.deleteById(id);
			msg = "Record Deleted";
		}
		catch(Exception e){
			msg ="Delete Issue";
		}
		return msg;
	}
	

}
