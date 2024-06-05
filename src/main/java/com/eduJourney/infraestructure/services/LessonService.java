package com.eduJourney.infraestructure.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.eduJourney.api.dto.request.LessonRequest;
import com.eduJourney.api.dto.request.update.LessonUpdateRequest;
import com.eduJourney.api.dto.response.LessonBasicResponse;

import com.eduJourney.domain.entities.Lesson;
import com.eduJourney.domain.repositories.CourseRepository;
import com.eduJourney.domain.repositories.LessonRepository;
import com.eduJourney.infraestructure.abstract_services.ILessonService;
import com.eduJourney.utils.exceptions.BadRequestException;
import com.eduJourney.utils.mappers.LessonMapper;

@Service
public class LessonService implements ILessonService {
  @Autowired
  private LessonMapper lessonMapper;
  @Autowired
  private LessonRepository lessonRepository;
  @Autowired
  private CourseRepository  courseRepository;

  @Override
  public LessonBasicResponse create(LessonRequest request) {
    Lesson lesson = this.lessonMapper.toEntity(request);
    return this.lessonMapper.toResponse(this.lessonRepository.save(lesson));
  }

  @Override
  public void delete(UUID id) {
    Lesson lesson = this.find(id);

    this.lessonRepository.delete(lesson);

  }

  @Override
  public Page<LessonBasicResponse> getAll(int page, int size) {
    if (page < 0)
      page = 0;
    PageRequest pagination = PageRequest.of(page, size);
    return this.lessonRepository.findAll(pagination).map(this.lessonMapper::toResponse);

  }

  @Override
  public LessonBasicResponse getById(UUID id) {

    return this.lessonMapper.toResponse(this.find(id));
  }

  private Lesson find(UUID id) {

    return this.lessonRepository.findById(id).orElseThrow(() -> new BadRequestException("Lesson not found"));

  }

  @Override
  public Page<LessonBasicResponse> findByCourseId(UUID courseId, int page, int size) {
     if (page < 0) page = 0;
    PageRequest pagination = PageRequest.of(page, size);
    
    return this.lessonRepository.findByCourseId(courseId , pagination).map(this.lessonMapper::toResponse);
   
  }

  @Override
  public LessonBasicResponse update(LessonUpdateRequest request, UUID id) {
    Lesson existingLesson = this.find(id);
    existingLesson = this.lessonMapper.UpdateToEntity(request, id);
    existingLesson.setId(id);
    return this.lessonMapper.toResponse(this.lessonRepository.save(existingLesson));
  }

}
