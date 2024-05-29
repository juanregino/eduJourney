package com.eduJourney.api.dto.request;

import java.util.UUID;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequest {
  @NotBlank(message = "Name cannot be blank")
  @Min(value = 3, message = "Name must be greater than 3 characters")
  private String name;
  @NotBlank(message = "Description cannot be blank")
  @Min(value = 3, message = "Description must be greater than 3 characters")
  private String description;
  @NotNull(message = "Teacher id cannot be null")
  @Min(value = 1, message = "Teacher id must be greater than 0")
  private UUID teacherId;
  @NotNull(message = "Enrollment id cannot be null")
  @Min(value = 1, message = "Enrollment id must be greater than 0")
  private UUID enrollmentId;
  @NotNull(message = "Message id cannot be null")
  @Min(value = 1, message = "Message id must be greater than 0")
  private UUID messageId;
  @NotNull(message = "Lesson id cannot be null")
  @Min(value = 1, message = "Lesson id must be greater than 0")
  private UUID lessonId;
}
