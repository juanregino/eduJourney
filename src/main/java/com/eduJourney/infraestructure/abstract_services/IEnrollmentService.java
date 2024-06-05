package com.eduJourney.infraestructure.abstract_services;

import java.util.UUID;

import org.springframework.data.domain.Page;

import com.eduJourney.api.dto.request.EnrollmentRequest;
import com.eduJourney.api.dto.response.EnrollmentResponse;

public interface IEnrollmentService extends CrudService<EnrollmentRequest,EnrollmentResponse,UUID>{
  Page<EnrollmentResponse> findByUserId(UUID userId , int page, int size);

  Page<EnrollmentResponse> findByCourseId(UUID userId, int page, int size);
}
