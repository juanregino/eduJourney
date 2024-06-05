package com.eduJourney.infraestructure.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.eduJourney.api.dto.request.CourseRequest;
import com.eduJourney.api.dto.request.update.CourseUpdateRequest;
import com.eduJourney.api.dto.response.CourseBasicResponse;
import com.eduJourney.domain.entities.Course;
import com.eduJourney.domain.repositories.CourseRepository;
import com.eduJourney.infraestructure.abstract_services.ICourseService;
import com.eduJourney.utils.exceptions.BadRequestException;
import com.eduJourney.utils.mappers.CourseMapper;

@Service
public class CourseService implements ICourseService {
   @Autowired
   private CourseRepository courseRepository;
   @Autowired
   private CourseMapper courseMapper;
  @Override
  public CourseBasicResponse create(CourseRequest request) {
    Course course = this.courseMapper.toEntity(request);
    return this.courseMapper.toResponse(courseRepository.save(course));
    
  }

  @Override
  public void delete(UUID id) {
    Course course = this.find(id);
    this.courseRepository.delete(course);
   
    
  }

  @Override
  public Page<CourseBasicResponse> getAll(int page, int size) {
    if (page < 0 ) page = 0;
    PageRequest pagination = PageRequest.of(page, size);
    return this.courseRepository.findAll(pagination).map(this.courseMapper::toResponse);
  }
   
  

  @Override
  public CourseBasicResponse getById(UUID id) {
    Course course = this.find(id);
    return this.courseMapper.toResponse(course);
  }
   
  private Course find(UUID id) {
    return this.courseRepository.findById(id).orElseThrow(() -> new BadRequestException("Course not found"));
  }

  @Override
  public CourseBasicResponse update(CourseUpdateRequest request, UUID id) {
    Course course = this.find(id);
    course = this.courseMapper.UpdateToEntity(request,id);
    course.setId(id);
    return this.courseMapper.toResponse(this.courseRepository.save(course));
 
  }

  

}
