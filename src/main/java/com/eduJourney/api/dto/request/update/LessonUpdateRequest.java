package com.eduJourney.api.dto.request.update;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class LessonUpdateRequest {
  @NotBlank(message = "Title cannot be blank")
 @Size(min = 3, max = 100, message = " Title must be between 3 and 100 characters")
   private String title;
   @NotBlank(message = "Content cannot be blank")
   private String content;
}
