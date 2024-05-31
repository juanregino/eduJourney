package com.eduJourney.domain.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduJourney.domain.entities.Course;

public interface CourseRepository extends JpaRepository<Course, UUID> { 
  
}
