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

import com.eduJourney.api.dto.request.LessonRequest;
import com.eduJourney.api.dto.request.update.LessonUpdateRequest;
import com.eduJourney.api.dto.response.LessonBasicResponse;
import com.eduJourney.infraestructure.abstract_services.ILessonService;

@RestController
@RequestMapping("/lesson")
public class LessonController {
  @Autowired
  private ILessonService lessonService;

  @PostMapping
  public ResponseEntity<LessonBasicResponse> createLesson(@Validated @RequestBody LessonRequest request){
    
    return  ResponseEntity.ok(this.lessonService.create(request));
  }

  @GetMapping
  public ResponseEntity<Page<LessonBasicResponse>> getAllLessons(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size){
    return ResponseEntity.ok(this.lessonService.getAll(page - 1, size));
  }

  @PutMapping("/{id}")
  public ResponseEntity<LessonBasicResponse> updateLesson(@PathVariable UUID id, @Validated @RequestBody LessonUpdateRequest request){
    return ResponseEntity.ok(this.lessonService.update(request,id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteLesson(@PathVariable UUID id){
    this.lessonService.delete(id);
    return ResponseEntity.noContent().build();
  }
  @GetMapping("/{courseId}")
  public ResponseEntity<Page<LessonBasicResponse>> findByCourseId(@PathVariable UUID courseId, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size){
    return ResponseEntity.ok(this.lessonService.findByCourseId(courseId, page - 1, size));
  }
  @GetMapping("/{id}")
  public ResponseEntity<LessonBasicResponse> findById(@PathVariable UUID id){
    return ResponseEntity.ok(this.lessonService.getById(id));
  }
}
