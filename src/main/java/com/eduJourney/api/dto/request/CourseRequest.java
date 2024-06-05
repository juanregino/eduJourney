package com.eduJourney.api.dto.request;

import java.util.UUID;

import com.eduJourney.api.dto.request.update.CourseUpdateRequest;

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
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequest  extends CourseUpdateRequest {
 
  @NotNull(message = "Teacher id cannot be null")
  // @Min(value = 1, message = "Teacher id must be greater than 0")
  private UUID teacherId; 

}
