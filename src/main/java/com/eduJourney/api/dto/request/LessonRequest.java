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
@AllArgsConstructor
@NoArgsConstructor
public class LessonRequest {
  @NotBlank(message = "Title cannot be blank")
  @Min  (value = 3, message = "Title must be greater than 3 characters")
   private String title;
   @NotBlank(message = "Content cannot be blank")
   private String content;
   @NotNull(message = "Course id cannot be null")
   @Min(value = 1, message = "Course id must be greater than 0")
   private UUID courseId;
   @NotNull(message = "Assignment id cannot be null")
   @Min(value = 1, message = "Assignment id must be greater than 0")
   private UUID assignmentId;  
}
