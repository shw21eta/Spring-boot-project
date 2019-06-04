package com.example.course;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.topics.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
			
//	get all the courses
	@RequestMapping("/courses")
	public List<Course> getAllCourses(){
		return courseService.getAllCourses();
	}
	
//	get all the courses containing given topic
 	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCoursesByTopic(@PathVariable String id) {
		return courseService.getAllCoursesByTopic(id);
	}
 	
// 	get course details of specific courseId(id) 
 	@RequestMapping("/topics/{topicId}/courses/{id}")
 	public Course getCourse(@PathVariable String id) {
 		return courseService.getCourse(id);
 	}
 	
 	
// 	add a course details
 	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
 	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
 		course.setTopic(new Topic(topicId, "", ""));
 		courseService.addCourse(course);
 	}
 	
// 	modify course
 	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
 	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
 		course.setTopic(new Topic(topicId, "", ""));
 		courseService.updateCourse(id, course);
 	}
 	
// 	delete course
 	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
 	public void deleteCourse(@PathVariable String id) {
 		 courseService.deleteCourse(id);
 	}
}
