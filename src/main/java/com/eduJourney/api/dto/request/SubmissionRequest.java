package com.eduJourney.api.dto.request;
import java.time.LocalDate;
import java.util.UUID;

import com.eduJourney.api.dto.request.update.SubmissionUpdateRequest;


import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionRequest extends SubmissionUpdateRequest {
  
  @FutureOrPresent(message = "Date cannot be in the past")
  @NotNull(message = "Date cannot be null")
  private LocalDate date;
  @NotNull(message = "User id cannot be null")

  private UUID userId;
  @NotNull(message = "Assignment id cannot be null")
 
  private UUID assignmentId;
}
