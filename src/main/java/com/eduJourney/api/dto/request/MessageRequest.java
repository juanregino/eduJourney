package com.eduJourney.api.dto.request;

import java.time.LocalDate;
import java.util.UUID;

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
public class MessageRequest {
  @NotBlank(message = "Content cannot be blank")
  private String content;
  @FutureOrPresent(message = "Date cannot be in the past")
  @NotBlank(message = "Date cannot be blank")
  private LocalDate date;
  @NotNull(message = "Recipient id cannot be null")
  @Min(value = 1, message = "Recipient id must be greater than 0")
  private UUID recipientId;
  @NotNull(message = "Sender id cannot be null")
  @Min(value = 1, message = "Sender id must be greater than 0")
  private UUID senderId;
  @NotNull(message = "Course id cannot be null")
  @Min(value = 1, message = "Course id must be greater than 0")
  private UUID courseId;
}
