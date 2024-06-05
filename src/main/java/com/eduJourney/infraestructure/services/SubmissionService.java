package com.eduJourney.infraestructure.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.eduJourney.api.dto.request.SubmissionRequest;
import com.eduJourney.api.dto.request.update.SubmissionUpdateRequest;
import com.eduJourney.api.dto.response.SubmissionBasicResponse;
import com.eduJourney.domain.entities.Assignment;
import com.eduJourney.domain.entities.Submission;
import com.eduJourney.domain.entities.User;
import com.eduJourney.domain.repositories.AssignmentRepository;
import com.eduJourney.domain.repositories.SubmissionRepository;
import com.eduJourney.domain.repositories.UserRepository;
import com.eduJourney.infraestructure.abstract_services.ISubmissionService;
import com.eduJourney.utils.exceptions.BadRequestException;
import com.eduJourney.utils.mappers.SubmissionMaper;
@Service
public class SubmissionService  implements ISubmissionService {
  @Autowired
  private SubmissionRepository submissionRepository;
  @Autowired
  private SubmissionMaper submissionMapper;
  @Autowired
  private AssignmentRepository assignmentRepository;
  @Autowired
  private UserRepository userRepository;
  @Override
  public SubmissionBasicResponse create(SubmissionRequest request) {
    Submission submission = this.submissionMapper.toEntity(request);

    return this.submissionMapper.toResponse(this.submissionRepository.save(submission));
  }

  @Override
  public void delete(UUID id) {
    
    Submission submission = this.find(id);

    this.submissionRepository.delete(submission);

    
  }

  @Override
  public Page<SubmissionBasicResponse> getAll(int page, int size) {
    if(page < 0 ) page = 0;
    PageRequest pagination = PageRequest.of(page, size);
    return this.submissionRepository.findAll(pagination).map(this.submissionMapper::toResponse);
  }

  @Override
  public SubmissionBasicResponse getById(UUID id) {
    
    return this.submissionMapper.toResponse(this.find(id));
   
  }

  @Override
  public SubmissionBasicResponse update(SubmissionUpdateRequest request, UUID id) {
    Submission submission = this.find(id);
    submission = this.submissionMapper.UpdateToEntity(request,id);
    submission.setId(id);
   
    return  this.submissionMapper.toResponse(this.submissionRepository.save(submission));
   
  }
 @Override
  public Page<SubmissionBasicResponse> findByAssignmentId(UUID assignmentId, int page, int size) {
   Assignment assignment = this.assignmentRepository.findById(assignmentId).orElseThrow(()-> new BadRequestException("Assignment not found"));
   
   return this.submissionRepository.findByAssignmentId(assignment , PageRequest.of(page, size)).map(this.submissionMapper::toResponse);
  }
  @Override
  public Page<SubmissionBasicResponse> findByUserId(UUID userId, int page, int size) {
    User user = this.userRepository.findById(userId).orElseThrow(()-> new BadRequestException("User not found"));
    return this.submissionRepository.findByUserId(user , PageRequest.of(page, size)).map(this.submissionMapper::toResponse);
  }



  private Submission find(UUID id) {
    return this.submissionRepository.findById(id).orElseThrow(() -> new BadRequestException("Submission not found"));
  }
  
}
