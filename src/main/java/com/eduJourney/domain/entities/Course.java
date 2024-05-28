package com.eduJourney.domain.entities;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  @Column(length = 100, nullable = false)

  private String name;
  @Lob
  private String description;
  @ManyToOne
  @JoinColumn(name = "instructor_id", referencedColumnName = "id")  
  private User instructor;

  @OneToMany(
    mappedBy = "course",
    fetch = FetchType.LAZY,
    cascade = CascadeType.ALL,
    orphanRemoval = true    
  )
  private List<Enrollment> enrollments; 

  @OneToMany(
    mappedBy = "course",
    fetch = FetchType.LAZY,
    cascade = CascadeType.ALL,
    orphanRemoval = true
  )
  private List<Message> messages;
  
  @OneToMany(
    mappedBy = "course",
    fetch = FetchType.EAGER,
    cascade = CascadeType.ALL,
    orphanRemoval = true
  )
  private List<Lesson> lessons;
}
