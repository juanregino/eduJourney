package com.eduJourney.utils.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eduJourney.api.dto.request.CourseRequest;
import com.eduJourney.api.dto.response.CourseBasicResponse;
import com.eduJourney.domain.entities.Course;
import com.eduJourney.domain.entities.User;
import com.eduJourney.domain.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CourseMapper {
  @Autowired
  private final UserRepository userRepository;
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
}
