package com.eduJourney.api.dto.request.update;

import java.math.BigDecimal;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class SubmissionUpdateRequest {
  @NotBlank (message = "Content cannot be blank")
  private String content;
  @NotNull(message = "Grade cannot be null")
  @Digits(integer = 3, fraction = 2, message = "The value must be a number with up to 3 integer digits and 2 fractional digits")
  private BigDecimal grade;
}
