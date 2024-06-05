package com.eduJourney.api.dto.request.update;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentUpdateRequest {
    @NotBlank(message = "Title cannot be blank")
   @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")  
  private String title;
  @NotBlank(message = "Description cannot be blank")
  @Size(min = 3, max = 100, message = "Description must be between 3 and 100 characters")
  private String description;
  @FutureOrPresent(message = "Due date cannot be in the past")
  @NotNull(message = "Due date cannot be null")
  private LocalDate dueDate;
}
