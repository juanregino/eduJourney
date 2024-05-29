package com.eduJourney.api.dto.request;

import java.util.UUID;

import com.eduJourney.utils.enums.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
  @NotBlank(message = "Username cannot be blank")
  @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
  private String userName;
  @NotBlank(message = "Password cannot be blank")
  @Size(min = 8, max = 100, message = "Password must be between 8 and 100 characters")
  private String password;
  @Email
  private String email;
  @NotBlank(message = "Full name cannot be blank")
  @Size(min = 3, max = 100, message = "Full name must be between 3 and 100 characters")
  private String fullName;
  @NotBlank(message = "Role cannot be blank")
  private Role role;
  
  @NotNull(message = "Enrollment id cannot be null")
  @Min(value = 1, message = "Enrollment id must be greater than 0")
  private UUID enrollmentId;
  @NotNull(message = "Course id cannot be null")
  @Min(value = 1, message = "Course id must be greater than 0")
  private UUID courseId;  
 @NotNull(message = "Submission id cannot be null")
 @Min(value = 1, message = "Submission id must be greater than 0")
  private UUID submissionId;
}