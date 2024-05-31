package com.eduJourney.domain.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduJourney.domain.entities.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, UUID> {
  
}
