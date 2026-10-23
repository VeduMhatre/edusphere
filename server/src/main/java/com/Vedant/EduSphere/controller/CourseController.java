package com.Vedant.EduSphere.controller;

import com.Vedant.EduSphere.entity.Course;
import com.Vedant.EduSphere.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@CrossOrigin(origins="*")
public class CourseController {

	private CourseService service;
	
	public CourseController(CourseService service){
		this.service=service;
	}

	@PostMapping("/add")
	public String addCourse(@RequestBody Course c){
		return service.addCourse(c);
	}
	
	@GetMapping("/all")
	public List<Course> getCourse(){
		return service.getCourse();
	}	

	@PutMapping({"/update","/update/{id}"})
	public String updateCourse(@PathVariable(required=false) Long id, @RequestBody Course c){
		if (id != null) {
        		c.setId(id);
    		}
		return service.updateCourse(c); 
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteCourse(@PathVariable Long id){
		return service.deleteCourse(id);
	}
}
