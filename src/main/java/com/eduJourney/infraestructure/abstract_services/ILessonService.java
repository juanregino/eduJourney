package com.eduJourney.infraestructure.abstract_services;

import java.util.UUID;

import org.springframework.data.domain.Page;

import com.eduJourney.api.dto.request.LessonRequest;
import com.eduJourney.api.dto.request.update.LessonUpdateRequest;
import com.eduJourney.api.dto.response.LessonBasicResponse;
import com.eduJourney.domain.entities.Lesson;

public interface ILessonService extends CrudService<LessonRequest,LessonBasicResponse,UUID>,UpdateService<LessonUpdateRequest,LessonBasicResponse,UUID>{
  Page<LessonBasicResponse> findByCourseId(UUID courseId , int page, int size);
}
