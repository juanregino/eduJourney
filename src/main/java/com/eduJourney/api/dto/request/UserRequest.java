package com.eduJourney.api.dto.request;



import com.eduJourney.api.dto.request.update.UserUpdateRequest;
import com.eduJourney.utils.enums.Role;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

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
