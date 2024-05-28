package com.eduJourney.domain.entities;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  @Column (nullable = false)
  private LocalDate date;
  @ManyToOne
  @JoinColumn(name = "user_id" , referencedColumnName = "id")
  private User user;
  @ManyToOne
  @JoinColumn(name = "course_id" , referencedColumnName = "id")
  private Course course;  
}
