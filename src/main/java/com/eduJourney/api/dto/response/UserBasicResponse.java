package com.eduJourney.api.dto.response;

import java.util.UUID;

import com.eduJourney.utils.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserBasicResponse {
  private UUID id;
  private String userName;
  private String password;
  private String email;
  private String fullName;
  private Role role;
  

  
}
