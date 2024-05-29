package com.eduJourney.api.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;



import jakarta.validation.constraints.Digits;
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
public class SubmissionRequest {
  @NotBlank (message = "Content cannot be blank")
  private String content;
  @NotNull(message = "Grade cannot be null")
  @Digits(integer = 3, fraction = 2, message = "The value must be a number with up to 3 integer digits and 2 fractional digits")
  private BigDecimal grade;
  @FutureOrPresent(message = "Date cannot be in the past")
  @NotNull(message = "Date cannot be null")
  private LocalDate date;
  @NotNull(message = "User id cannot be null")
  @Min(value = 1, message = "User id must be greater than 0")
  private UUID userId;
  @NotNull(message = "Assignment id cannot be null")
  @Min(value = 1, message = "Assignment id must be greater than 0")
  private UUID assignmentId;
}
