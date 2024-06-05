package com.eduJourney.api.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eduJourney.api.dto.request.AssignmentRequest;
import com.eduJourney.api.dto.request.update.AssignmentUpdateRequest;
import com.eduJourney.api.dto.response.AssignmentBasicResponse;
import com.eduJourney.infraestructure.abstract_services.IAssignmentService;

@RestController
@RequestMapping("/assignment")
public class AssignmentController {
  @Autowired
  private IAssignmentService assignmentService;

  @PostMapping
  public ResponseEntity<AssignmentBasicResponse> create (@RequestBody AssignmentRequest assignmentRequest){
   return ResponseEntity.ok(this.assignmentService.create(assignmentRequest));
  }

  @GetMapping
  public ResponseEntity<Page<AssignmentBasicResponse>> getAll(@RequestParam(defaultValue = "1")int page,@RequestParam(defaultValue = "10") int size){
    return ResponseEntity.ok(this.assignmentService.getAll(page - 1, size));
  }
  @PutMapping("/{id}")
  public ResponseEntity<AssignmentBasicResponse> update(@PathVariable UUID id, @RequestBody AssignmentUpdateRequest assignmentUpdateRequest){
   return ResponseEntity.ok(this.assignmentService.update(assignmentUpdateRequest,id));  
  }
  @GetMapping("/{id}")
  public ResponseEntity<AssignmentBasicResponse> getById(@PathVariable UUID id){
    return ResponseEntity.ok(this.assignmentService.getById(id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable UUID id){
    this.assignmentService.delete(id);
    return ResponseEntity.noContent().build();
  }
  @GetMapping("/{lessonId}")
  public ResponseEntity<Page<AssignmentBasicResponse>> getAllByLesson(@PathVariable UUID lessonId, @RequestParam(defaultValue = "1")int page,@RequestParam(defaultValue = "10") int size){
    return ResponseEntity.ok(this.assignmentService.getAllByLesson(lessonId, page - 1, size));
  }
}
