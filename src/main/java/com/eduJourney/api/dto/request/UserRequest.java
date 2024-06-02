package com.eduJourney.api.dto.request;

import java.util.UUID;

import com.eduJourney.api.dto.request.update.UserUpdateRequest;
import com.eduJourney.utils.enums.Role;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
@EqualsAndHashCode(callSuper = false)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest  extends UserUpdateRequest {

  @NotNull(message = "Role cannot be blank")
  private Role role;
  
 
}
