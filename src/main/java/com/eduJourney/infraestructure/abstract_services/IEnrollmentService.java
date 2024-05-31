package com.eduJourney.infraestructure.abstract_services;

import java.util.UUID;

import com.eduJourney.api.dto.request.EnrollmentRequest;
import com.eduJourney.api.dto.response.EnrollmentResponse;

public interface IEnrollmentService extends CrudService<EnrollmentRequest,EnrollmentResponse,UUID>{
  
}
