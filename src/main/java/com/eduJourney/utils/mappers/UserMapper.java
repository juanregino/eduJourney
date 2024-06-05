package com.eduJourney.utils.mappers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eduJourney.api.dto.request.UserRequest;
import com.eduJourney.api.dto.request.update.UserUpdateRequest;
import com.eduJourney.api.dto.response.UserBasicResponse;
import com.eduJourney.domain.entities.User;
import com.eduJourney.domain.repositories.UserRepository;
import com.eduJourney.utils.exceptions.BadRequestException;
@Component
public class UserMapper {
  
  @Autowired
  public UserRepository userRepository;

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
  public User UpdateToEntity(UserUpdateRequest request, UUID id){
    User user = this.userRepository.findById(id).orElseThrow(() -> new BadRequestException("User not found"));
return User.builder()
               .userName(request.getUserName())
               .password(request.getPassword())
               .email(request.getEmail())
               .fullName(request.getFullName())
               .role(user.getRole())
               .build();
  }
}
