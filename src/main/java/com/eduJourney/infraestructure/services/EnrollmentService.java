package com.eduJourney.infraestructure.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.eduJourney.api.dto.request.EnrollmentRequest;
import com.eduJourney.api.dto.response.EnrollmentResponse;
import com.eduJourney.domain.entities.Enrollment;
import com.eduJourney.domain.repositories.EnrollmentRepository;
import com.eduJourney.infraestructure.abstract_services.IEnrollmentService;
import com.eduJourney.utils.exceptions.BadRequestException;
import com.eduJourney.utils.mappers.EnrollmentMapper;

@Service
public class EnrollmentService implements IEnrollmentService {
  @Autowired
  private EnrollmentMapper enrollmentMapper;
  @Autowired
  private EnrollmentRepository enrollmentRepository;
  @Override
  public EnrollmentResponse create(EnrollmentRequest request) {
    Enrollment enrollment = this.enrollmentMapper.toEntity(request);
    return this.enrollmentMapper.toResponse(this.enrollmentRepository.save(enrollment));
  }

  @Override
  public void delete(UUID id) {
    
    Enrollment enrollment = this.find(id);
    this.enrollmentRepository.delete(enrollment);
    
  }

  @Override
  public Page<EnrollmentResponse> getAll(int page, int size) {
    
    return null;
  }

  @Override
  public EnrollmentResponse getById(UUID id) {
    
    return this.enrollmentMapper.toResponse(this.find(id));
  }

  private Enrollment find(UUID id) {
    return this.enrollmentRepository.findById(id).orElseThrow(() -> new BadRequestException("Enrollment not found"));
  } 

  @Override
  public Page<EnrollmentResponse> findByUserId(UUID userId, int page, int size) {
    PageRequest pagination = PageRequest.of(page, size);
    return this.enrollmentRepository.findByUserId(userId, pagination).map(this.enrollmentMapper::toResponse);
  }
  @Override
  public Page<EnrollmentResponse> findByCourseId(UUID courseId, int page, int size) {
    PageRequest pagination = PageRequest.of(page, size);
    return this.enrollmentRepository.findByCourseId(courseId, pagination).map(this.enrollmentMapper::toResponse);
  }
}
