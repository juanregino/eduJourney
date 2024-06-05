package com.eduJourney.utils.mappers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eduJourney.api.dto.request.CourseRequest;
import com.eduJourney.api.dto.request.update.CourseUpdateRequest;
import com.eduJourney.api.dto.response.CourseBasicResponse;
import com.eduJourney.domain.entities.Course;
import com.eduJourney.domain.entities.User;
import com.eduJourney.domain.repositories.CourseRepository;
import com.eduJourney.domain.repositories.UserRepository;
import com.eduJourney.utils.exceptions.BadRequestException;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CourseMapper {
  @Autowired
  private final UserRepository userRepository;
  @Autowired
  private final CourseRepository courseRepository;
  public CourseBasicResponse toResponse (Course entity){
    return CourseBasicResponse.builder()
                              .id(entity.getId())
                              .name(entity.getName())
                              .description(entity.getDescription())
                              .build();
  }

  public Course toEntity(CourseRequest request){
    User teacher = this.userRepository.findById(request.getTeacherId()).orElseThrow();
    return Course.builder()
                 .name(request.getName())
                 .description(request.getDescription())
                 .enrollments(null)
                 .teacher(teacher)
                 .build();
  }
  public Course UpdateToEntity(CourseUpdateRequest request, UUID id){
    Course course = this.courseRepository.findById(id).orElseThrow(() -> new BadRequestException("Course not found"));
    course.setName(request.getName());
    course.setDescription(request.getDescription());
    course.setTeacher(this.userRepository.findById(course.getTeacher().getId()).orElseThrow());
    return course;
  }
}
