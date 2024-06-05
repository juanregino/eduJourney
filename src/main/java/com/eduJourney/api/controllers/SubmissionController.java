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

import com.eduJourney.api.dto.request.SubmissionRequest;
import com.eduJourney.api.dto.request.update.SubmissionUpdateRequest;
import com.eduJourney.api.dto.response.SubmissionBasicResponse;
import com.eduJourney.infraestructure.abstract_services.ISubmissionService;

@RestController
@RequestMapping("/submissions")
public class SubmissionController {
  
  @Autowired
  private ISubmissionService submissionService;

  @PostMapping
  public ResponseEntity<SubmissionBasicResponse> createSubmission(@Validated @RequestBody SubmissionRequest request){
    return ResponseEntity.ok(this.submissionService.create(request));
  }
  @GetMapping
  public ResponseEntity<Page<SubmissionBasicResponse>> getAllSubmissions(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size
                                                                      ){
    return ResponseEntity.ok(this.submissionService.getAll(page,size));
  }
  @PutMapping("/{id}")
  public ResponseEntity<SubmissionBasicResponse> updateSubmission(@PathVariable UUID id, @Validated @RequestBody SubmissionUpdateRequest request){
    return ResponseEntity.ok(this.submissionService.update(request,id));
  }

  @DeleteMapping("/{id}") 
  public ResponseEntity<Void> deleteSubmission(@PathVariable UUID id){
    this.submissionService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/assignments/{assignmentId}")
  public ResponseEntity<Page<SubmissionBasicResponse>> getSubmissionsByAssignment(@PathVariable UUID assignmentId, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size
                                                                      ){
    return ResponseEntity.ok(this.submissionService.findByAssignmentId(assignmentId,page,size));
  }
  @GetMapping("/users/{userId}")
  public ResponseEntity<Page<SubmissionBasicResponse>> getSubmissionsByUser(@PathVariable UUID userId, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size
                                                                      ){
    return ResponseEntity.ok(this.submissionService.findByUserId(userId,page,size));
  }
}
