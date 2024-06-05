package com.eduJourney.api.dto.request.update;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CourseUpdateRequest {
  @NotBlank(message = "Name cannot be blank")
  @Size(min = 3, max = 100, message = " Name must be between 3 and 100 characters")
  private String name;
  @NotBlank(message = "Description cannot be blank")
 @Size(min = 3, max = 100, message = "Description must be between 3 and 100 characters")
  private String description;
}
