package com.eduJourney.infraestructure.abstract_services;

import java.util.UUID;

import com.eduJourney.api.dto.request.CourseRequest;
import com.eduJourney.api.dto.response.CourseBasicResponse;

public interface ICourseService extends CrudService<CourseRequest,CourseBasicResponse,UUID>{
  
}
