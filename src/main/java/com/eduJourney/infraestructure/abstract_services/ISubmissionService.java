package com.eduJourney.infraestructure.abstract_services;

import java.util.UUID;

import org.springframework.data.domain.Page;

import com.eduJourney.api.dto.request.SubmissionRequest;
import com.eduJourney.api.dto.request.update.SubmissionUpdateRequest;
import com.eduJourney.api.dto.response.SubmissionBasicResponse;

public interface ISubmissionService extends CrudService<SubmissionRequest,SubmissionBasicResponse,UUID>, UpdateService<SubmissionUpdateRequest,SubmissionBasicResponse,UUID>{
  
  Page<SubmissionBasicResponse> findByAssignmentId(UUID assignmentId , int page, int size);
  Page<SubmissionBasicResponse> findByUserId(UUID userId , int page, int size);
}
