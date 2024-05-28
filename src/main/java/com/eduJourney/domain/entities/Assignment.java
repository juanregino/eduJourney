package com.eduJourney.domain.entities;

import java.time.LocalDate;
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
public class Assignment {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  @Column(nullable = false , length = 100)
  private String title;
  @Lob
  @Column(nullable = false)
  private String description;
  @Column(nullable = false)
  private LocalDate dueDate;
   
  @OneToMany(
    mappedBy = "assignment",
    fetch = FetchType.LAZY,
    cascade = CascadeType.ALL,
    orphanRemoval = true  
  )
  private List<Submission> submissions;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "lesson_id", referencedColumnName = "id")
  private Lesson lesson;

}
