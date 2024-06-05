package com.eduJourney.domain.repositories;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.eduJourney.domain.entities.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, UUID> {
  Page<Enrollment> findByUserId(UUID id, Pageable pageable);
  
  Page<Enrollment> findByCourseId(UUID courseId, Pageable pageable);
}
