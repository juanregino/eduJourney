package com.eduJourney.api.dto.response;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentBasicResponse {
  private UUID id;
  private String title;
  private String description;
  private String dueDate;
}
