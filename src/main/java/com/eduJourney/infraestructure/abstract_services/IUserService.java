package com.eduJourney.infraestructure.abstract_services;

import java.util.UUID;

import com.eduJourney.api.dto.request.UserRequest;
import com.eduJourney.api.dto.request.update.UserUpdateRequest;
import com.eduJourney.api.dto.response.UserBasicResponse;

public interface IUserService extends CrudService<UserRequest,UserBasicResponse,UUID>, UpdateService<UserUpdateRequest,UserBasicResponse,UUID>{
  
}
