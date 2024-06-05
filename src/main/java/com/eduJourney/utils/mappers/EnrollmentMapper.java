package com.eduJourney.utils.mappers;

import org.springframework.stereotype.Component;

import com.eduJourney.api.dto.request.EnrollmentRequest;
import com.eduJourney.api.dto.response.EnrollmentResponse;
import com.eduJourney.domain.entities.Course;
import com.eduJourney.domain.entities.Enrollment;
import com.eduJourney.domain.entities.User;
import com.eduJourney.domain.repositories.CourseRepository;
import com.eduJourney.domain.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EnrollmentMapper {
  private final UserRepository userRepository;
  private final CourseRepository courseRepository;
  
  public EnrollmentResponse toResponse (Enrollment entity){
    
    return EnrollmentResponse.builder()
                             .id(entity.getId())
                             .date(entity.getDate())
                             .build();
  }

  public Enrollment toEntity (EnrollmentRequest request){
    User user = userRepository.findById(request.getUserId()).orElseThrow();
    Course course = courseRepository.findById(request.getCourseId()).orElseThrow();
    return Enrollment.builder()
                     .date(request.getDate())
                     .course(course)
                     .user(user)
                     .build();
                     
 }
}
