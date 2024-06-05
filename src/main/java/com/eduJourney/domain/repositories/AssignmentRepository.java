package com.eduJourney.domain.repositories;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.eduJourney.domain.entities.Assignment;
import com.eduJourney.domain.entities.Lesson;

public interface AssignmentRepository extends JpaRepository<Assignment,UUID> {
    Page<Assignment> findByLessonId(UUID lessonId , Pageable pageable);
}
