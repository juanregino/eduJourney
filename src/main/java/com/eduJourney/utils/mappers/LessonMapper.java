package com.eduJourney.utils.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eduJourney.api.dto.request.LessonRequest;
import com.eduJourney.api.dto.response.LessonBasicResponse;
import com.eduJourney.domain.entities.Course;
import com.eduJourney.domain.entities.Lesson;
import com.eduJourney.domain.repositories.CourseRepository;


import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LessonMapper {
  @Autowired
  private final CourseRepository courseRepository;
  public LessonBasicResponse toResponse(Lesson lesson) { 
    return LessonBasicResponse.builder()
                         .id(lesson.getId())
                         .title(lesson.getTitle())                         
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
                         
  }


