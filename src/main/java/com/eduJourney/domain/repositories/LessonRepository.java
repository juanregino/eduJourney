package com.eduJourney.domain.repositories;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.eduJourney.domain.entities.Course;
import com.eduJourney.domain.entities.Lesson;

public interface LessonRepository extends JpaRepository< Lesson, UUID> {
  Page<Lesson> findByCourseId(UUID courseId , Pageable pageable);
}
