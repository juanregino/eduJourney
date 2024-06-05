package com.eduJourney.infraestructure.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.eduJourney.api.dto.request.AssignmentRequest;
import com.eduJourney.api.dto.request.update.AssignmentUpdateRequest;
import com.eduJourney.api.dto.response.AssignmentBasicResponse;
import com.eduJourney.domain.entities.Assignment;
import com.eduJourney.domain.repositories.AssignmentRepository;
import com.eduJourney.infraestructure.abstract_services.IAssignmentService;
import com.eduJourney.utils.exceptions.BadRequestException;
import com.eduJourney.utils.mappers.AssignmentMapper;

@Service
public class AssignmentService implements IAssignmentService {
  @Autowired
  private AssignmentMapper assignmentMapper;
  @Autowired
  private AssignmentRepository assignmentRepository;
  @Override
  public AssignmentBasicResponse create(AssignmentRequest request) {
    Assignment assignment = this.assignmentMapper.toEntity(request);
    return this.assignmentMapper.toResponse(this.assignmentRepository.save(assignment));
    
  }

  @Override
  public void delete(UUID id) {
    Assignment assignment = this.find(id);
    this.assignmentRepository.delete(assignment);
    
  }

  @Override
  public Page<AssignmentBasicResponse> getAll(int page, int size) {
    if (page <0 ) page = 0;
    PageRequest pagination = PageRequest.of(page, size);
    return this.assignmentRepository.findAll(pagination).map(this.assignmentMapper::toResponse);

  }

  @Override
  public AssignmentBasicResponse getById(UUID id) {
    
    return this.assignmentMapper.toResponse(this.find(id));
  }

  @Override
  public AssignmentBasicResponse update(AssignmentUpdateRequest request, UUID id) {
    Assignment assignment = this.find(id);
    assignment = this.assignmentMapper.UpdateToEntity(request, id);
    assignment.setId(id);
    return this.assignmentMapper.toResponse(this.assignmentRepository.save(assignment));
  }

  private Assignment find(UUID id) {


      Assignment assignment = this.assignmentRepository.findById(id).orElseThrow(() -> new BadRequestException("Assignment not found"));
      return assignment;
    
  }
 @Override
  public Page<AssignmentBasicResponse> getAllByLesson(UUID lessonId, int page, int size) {
    if (page <0 ) page = 0;
    PageRequest pagination = PageRequest.of(page, size);
    return this.assignmentRepository.findByLessonId(lessonId , pagination).map(this.assignmentMapper::toResponse);
  }
  
}
