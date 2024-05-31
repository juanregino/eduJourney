package com.eduJourney.infraestructure.abstract_services;

import java.util.UUID;

import com.eduJourney.api.dto.request.AssignmentRequest;
import com.eduJourney.api.dto.response.AssignmentBasicResponse;

public interface IAssignmentService extends CrudService<AssignmentRequest,AssignmentBasicResponse,UUID>{
  
}
