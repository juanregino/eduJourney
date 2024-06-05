package com.eduJourney.infraestructure.abstract_services;

import java.util.UUID;

import org.springframework.data.domain.Page;

import com.eduJourney.api.dto.request.AssignmentRequest;
import com.eduJourney.api.dto.request.update.AssignmentUpdateRequest;
import com.eduJourney.api.dto.response.AssignmentBasicResponse;

public interface IAssignmentService extends CrudService<AssignmentRequest,AssignmentBasicResponse,UUID>, UpdateService<AssignmentUpdateRequest,AssignmentBasicResponse,UUID>{
   public Page<AssignmentBasicResponse> getAllByLesson(UUID lessonId, int page, int size);
}
