package com.eduJourney.domain.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduJourney.domain.entities.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment,UUID> {
  
}
