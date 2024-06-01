package com.eduJourney.utils.mappers;

import org.springframework.stereotype.Component;

import com.eduJourney.api.dto.request.UserRequest;
import com.eduJourney.api.dto.response.UserBasicResponse;
import com.eduJourney.domain.entities.User;
@Component
public class UserMapper {
  

  public UserBasicResponse toResponse(User entity){
    return UserBasicResponse.builder()
                            .id(entity.getId())
                            .userName(entity.getUserName())
                            .password(entity.getPassword())
                            .email(entity.getEmail())
                            .fullName(entity.getFullName())
                            .role(entity.getRole())
                            .build();
  }

  public User toEntity(UserRequest request){
    return User.builder()
               .userName(request.getUserName())
               .password(request.getPassword())
               .email(request.getEmail())
               .fullName(request.getFullName())
               .role(request.getRole())
               .build();
  }
}
