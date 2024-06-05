package com.eduJourney.domain.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduJourney.domain.entities.Course;
import com.eduJourney.domain.entities.Message;
import com.eduJourney.domain.entities.User;

public interface MessageRepository extends JpaRepository<Message, UUID> { 
  List<Message> findByCourseId(Course courseId);
  
  List<Message> findBySenderIdAndReceiverId(User senderId, User receiverId);
}
