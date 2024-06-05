package com.eduJourney.api.dto.request;

import java.util.UUID;

import com.eduJourney.api.dto.request.update.LessonUpdateRequest;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class LessonRequest  extends LessonUpdateRequest{
  
   @NotNull(message = "Course id cannot be null")
  //  @Min(value = 1, message = "Course id must be greater than 0")
   private UUID courseId;

}
