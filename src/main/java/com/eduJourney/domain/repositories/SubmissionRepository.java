package com.eduJourney.domain.repositories;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.eduJourney.domain.entities.Assignment;
import com.eduJourney.domain.entities.Submission;
import com.eduJourney.domain.entities.User;

public interface SubmissionRepository extends JpaRepository<Submission, UUID> {
  Page<Submission> findByUserId(User user , Pageable pageable);
  Page<Submission> findByAssignmentId(Assignment assignment ,
                                      Pageable pageable);
}
