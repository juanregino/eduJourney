package com.eduJourney.infraestructure.abstract_services;

import java.util.UUID;

import com.eduJourney.api.dto.request.SubmissionRequest;
import com.eduJourney.api.dto.response.SubmissionBasicResponse;

public interface ISubmissionService extends CrudService<SubmissionRequest,SubmissionBasicResponse,UUID>{
  
}
