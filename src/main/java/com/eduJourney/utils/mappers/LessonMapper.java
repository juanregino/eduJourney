package com.eduJourney.utils.mappers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eduJourney.api.dto.request.LessonRequest;
import com.eduJourney.api.dto.request.update.LessonUpdateRequest;
import com.eduJourney.api.dto.response.LessonBasicResponse;
import com.eduJourney.domain.entities.Course;
import com.eduJourney.domain.entities.Lesson;
import com.eduJourney.domain.repositories.CourseRepository;
import com.eduJourney.domain.repositories.LessonRepository;
import com.eduJourney.utils.exceptions.BadRequestException;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LessonMapper {
  @Autowired
  private final CourseRepository courseRepository;
  @Autowired
  private final LessonRepository lessonRepository;
  public LessonBasicResponse toResponse(Lesson lesson) { 
    return LessonBasicResponse.builder()
                         .id(lesson.getId())
                         .title(lesson.getTitle()) 
                         .content(lesson.getContent())                        
                         .build();
  }

  public Lesson toEntity(LessonRequest request) {
    Course course = courseRepository.findById(request.getCourseId()).orElseThrow(() -> new RuntimeException("Course not found"));
    return Lesson.builder()
                         .title(request.getTitle())
                         .content(request.getContent())
                         .course(course)
                         .build();
  }

  public Lesson UpdateToEntity(LessonUpdateRequest request, UUID id){
    Lesson lesson = this.lessonRepository.findById(id).orElseThrow(() -> new BadRequestException("Lesson not found"));
    Course course = courseRepository.findById(lesson.getCourse().getId()).orElseThrow(() -> new BadRequestException("Course not found"));
    lesson.setTitle(request.getTitle());
    lesson.setContent(request.getContent());
    lesson.setCourse(course);
    return lesson;
                         
  }

} 


