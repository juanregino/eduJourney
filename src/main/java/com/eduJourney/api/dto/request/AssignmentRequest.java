package com.eduJourney.api.dto.request;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentRequest {
  @NotBlank(message = "Title cannot be blank")
  @Min(value = 3, message = "Title must be greater than 3 characters")
  private String title;
  @NotBlank(message = "Description cannot be blank")
  @Min(value = 3, message = "Description must be greater than 3 characters")
  private String description;
  @FutureOrPresent(message = "Due date cannot be in the past")
  @NotNull(message = "Due date cannot be null")
  private LocalDate dueDate;
  @NotNull(message = "Submission id cannot be null")
  @Min(value = 1, message = "Submission id must be greater than 0")
  private UUID submissionId;
  @NotNull(message = "Lesson id cannot be null")
  @Min(value = 1, message = "Lesson id must be greater than 0")
  private UUID lessonId;
}
