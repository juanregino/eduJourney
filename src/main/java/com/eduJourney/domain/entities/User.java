package com.eduJourney.domain.entities;

import java.util.List;
import java.util.UUID;

import com.eduJourney.utils.enums.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  @Column(length = 50, nullable = false, unique = true)
  private String userName;
  @Column(length = 100, nullable = false)
  private String password;
  @Column(length = 100, nullable = false, unique = true)

  private String email;
  @Column(length = 100, nullable = false)
  private String fullName;
  @Column(length = 50, nullable = false)
  @Enumerated(EnumType.STRING)
  private Role role;
  
  @OneToMany(
    mappedBy = "user",
    fetch = FetchType.LAZY,
    cascade = CascadeType.ALL,
    orphanRemoval = true


  )
  private List<Enrollment> enrollments;
  
  @OneToMany(
    mappedBy = "teacher",
    fetch = FetchType.LAZY,
    cascade = CascadeType.ALL,
    orphanRemoval = true
  )
  private List<Course> courses;
 
  @OneToMany(
    mappedBy = "recipient",
    fetch = FetchType.LAZY,
    cascade = CascadeType.ALL,
    orphanRemoval = true
  )
  private List<Message> messagesReceived;

  @OneToMany(
    mappedBy = "sender",
    fetch = FetchType.LAZY, 
    cascade = CascadeType.ALL,
    orphanRemoval = true
  )
  private List<Message> messagesSent;

  @OneToMany(
    mappedBy = "user",
    fetch = FetchType.LAZY,
    cascade = CascadeType.ALL,
    orphanRemoval = true
  )
  private List<Submission> submissions;

}
