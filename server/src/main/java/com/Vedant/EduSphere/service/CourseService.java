package com.Vedant.EduSphere.service;

import com.Vedant.EduSphere.entity.Course;
import com.Vedant.EduSphere.repository.CourseRepository;
import org.springframework.dao.DataIntegrityViolationException;
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
		
		if(repo.existsByCourseCode(c.getCourseCode())){
			return "Error: Course code '" + c.getCourseCode() + "' already exists!";
		}
		
		if(c.getId() != null){
			return "Error: Do not provide an ID when creating a new course!";
		}
		try{
			repo.save(c);
			msg = "Record Created";
		}
		catch(DataIntegrityViolationException e){
			return "Error: Database constraint violation. Course code must be unique.";
		}
		catch(Exception e){
			msg = "Create Issue: " + e.getMessage();
		}
		return msg;
	}

	public List<Course> getCourse(){
		return repo.findAll();
	}

	public String updateCourse(Course c){
		String msg ="";
		if(c.getId() == null || !repo.existsById(c.getId())){
			return "Course Id " + (c.getId() == null ? "not provided" : c.getId() + " does not exist");  
		}
		try{
			repo.save(c);
			msg = "Record Updated";
		}
		catch(DataIntegrityViolationException e){
			return "Error: Database constraint violation. Course code must be unique.";
		}
		catch(Exception e){
			msg = "Update Issue: " + e.getMessage();
		}
		return msg;
	}

	public String deleteCourse(Long id){
		String msg="";
		if(id == null || !repo.existsById(id)){
			msg = "Course Id " + (id == null ? "not provided" : id + " does not exist");
		}
		else{
			try{
				repo.deleteById(id);
				msg = "Record Deleted";
			}
			catch(Exception e){
				msg ="Delete Issue";
			}
		}
		return msg;
	}	
}