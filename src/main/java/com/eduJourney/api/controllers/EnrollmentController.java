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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduJourney.api.dto.request.EnrollmentRequest;
import com.eduJourney.api.dto.response.EnrollmentResponse;
import com.eduJourney.infraestructure.abstract_services.IEnrollmentService;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
  @Autowired
  private IEnrollmentService enrollmentService;

  @PostMapping
  public ResponseEntity<EnrollmentResponse> createEnrollment(@Validated @RequestBody EnrollmentRequest request){
    return ResponseEntity.ok(this.enrollmentService.create(request));

  }
  @GetMapping("/{id}")
  public ResponseEntity<EnrollmentResponse> getEnrollmentById(@PathVariable UUID id){
    return ResponseEntity.ok(this.enrollmentService.getById(id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteEnrollment(@PathVariable UUID id){
    this.enrollmentService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/{userId}")
  public ResponseEntity<Page<EnrollmentResponse>> getEnrollmentsByUserId(@PathVariable UUID userId, int page, int size){
    return ResponseEntity.ok(this.enrollmentService.findByUserId(userId , page, size));
  }

  @GetMapping("/{courseId}")
  public ResponseEntity<Page<EnrollmentResponse>> getEnrollmentsByCourseId(@PathVariable UUID courseId, int page, int size){
    return ResponseEntity.ok(this.enrollmentService.findByCourseId(courseId , page, size));
  } 
}
