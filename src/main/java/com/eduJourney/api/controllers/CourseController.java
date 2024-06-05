package com.eduJourney.api.controllers;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eduJourney.api.dto.request.CourseRequest;
import com.eduJourney.api.dto.request.update.CourseUpdateRequest;
import com.eduJourney.api.dto.response.CourseBasicResponse;
import com.eduJourney.api.dto.response.SubmissionBasicResponse;
import com.eduJourney.infraestructure.abstract_services.ICourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
 @Autowired
 private ICourseService courseService;

 @PostMapping
 public ResponseEntity<CourseBasicResponse> createCourse(@Validated @RequestBody CourseRequest request){
  CourseBasicResponse course = this.courseService.create(request); 
  return ResponseEntity.ok(course);
 }

 @GetMapping
 public ResponseEntity<Page<CourseBasicResponse>> getAllCourses(@RequestParam(defaultValue = "1") int page,
                                                               @RequestParam(defaultValue = "10") int size){
  Page<CourseBasicResponse> courses = this.courseService.getAll(page - 1, size);
  return ResponseEntity.ok(courses);
 }

 @PutMapping("/{id}")
 public ResponseEntity<CourseBasicResponse> updateCourse(@PathVariable UUID id, @Validated @RequestBody CourseUpdateRequest request){
  CourseBasicResponse course = this.courseService.update(request,id);
  return ResponseEntity.ok(course);
 }

 @GetMapping("/{id}")
 public ResponseEntity<CourseBasicResponse> getSubmissions(@PathVariable UUID id){ 

    return ResponseEntity.ok(this.courseService.getById(id));
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteCourse(@PathVariable UUID id){
   this.courseService.delete(id);
   return ResponseEntity.noContent().build();
 }
 
}
