package com.eduJourney.domain.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduJourney.domain.entities.Message;

public interface MessageRepository extends JpaRepository<Message, UUID> { 
  
}
