package com.eduJourney.domain.entities;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID) 
  private UUID id;
  @Lob
  @Column(nullable = false)
  private String content;
  @Column(nullable = false)
  private LocalDate date;

 

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "recipient_id", referencedColumnName = "id")
  private User recipientId;
 @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "sender_id", referencedColumnName = "id")
  private User senderId;

 @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "course_id", referencedColumnName = "id")
  private Course course;
}
