package com.example.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
//	private List<Course> topics = new ArrayList<>(Arrays.asList(
//			new Course("1", "science", "general science"),
//			new Course("2", "Core java", "Core java description"),
//			new Course("3", "php", "php description")				
//			));
	
	public List<Course> getAllCoursesByTopic(String topicId){
//		return topics;
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	public Course getCourse(String id) {
//		return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
		
		return courseRepository.findOne(id);
	}

	public void addCourse(Course course) {
//		topics.add(topic);
		courseRepository.save(course);
		
	}
	
	public void updateCourse(String id,Course course) {
		courseRepository.save(course);
	}
	
	public void deleteCourse(String id) {
//		topics.removeIf(t-> t.getId().equals(id));
		courseRepository.delete(id);
	}
	
	public List<Course> getAllCourses() {
		List<Course> courses = new ArrayList<>();
		courseRepository.findAll().forEach(courses::add);
		return courses;
	}
}
