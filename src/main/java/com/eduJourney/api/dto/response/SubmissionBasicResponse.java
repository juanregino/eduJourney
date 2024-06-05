package com.eduJourney.api.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionBasicResponse {
  private UUID id;
  private String content;
  private LocalDate date;
  private BigDecimal grade;
}
