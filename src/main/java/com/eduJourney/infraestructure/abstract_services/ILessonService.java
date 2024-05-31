package com.eduJourney.infraestructure.abstract_services;

import java.util.UUID;

import com.eduJourney.api.dto.request.LessonRequest;
import com.eduJourney.api.dto.response.LessonBasicResponse;

public interface ILessonService extends CrudService<LessonRequest,LessonBasicResponse,UUID>{
  
}
