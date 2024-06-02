package com.eduJourney.infraestructure.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.eduJourney.api.dto.request.UserRequest;
import com.eduJourney.api.dto.request.update.UserUpdateRequest;
import com.eduJourney.api.dto.response.UserBasicResponse;

import com.eduJourney.domain.entities.User;

import com.eduJourney.domain.repositories.UserRepository;
import com.eduJourney.infraestructure.abstract_services.IUserService;
import com.eduJourney.utils.exceptions.BadRequestException;
import com.eduJourney.utils.mappers.UserMapper;

@Service
public class UserService implements IUserService {
  



  @Autowired
  private UserRepository userRepository;
  @Autowired
  private UserMapper userMapper;
 

  @Override
  public UserBasicResponse create(UserRequest request) {

    User user = this.userMapper.toEntity(request);

    return this.userMapper.toResponse(this.userRepository.save(user));
  }

  @Override
  public void delete(UUID id) {
    User user = this.find(id);
    this.userRepository.delete(user);
  }

  @Override
  public Page<UserBasicResponse> getAll(int page, int size) {
    if(page < 0 ) page = 0;
    PageRequest pagination = PageRequest.of(page, size);
    return this.userRepository.findAll(pagination).map(this.userMapper::toResponse);
  }

  @Override
  public UserBasicResponse getById(UUID id) {
    User user = this.find(id);
    return this.userMapper.toResponse(user);
   
  }

  

  private User find(UUID id) {

    return this.userRepository.findById(id).orElseThrow(() -> new BadRequestException("User not found"));

  }

  @Override
  public UserBasicResponse update(UserUpdateRequest request, UUID id) {
    //1. buscamos el usuario con el id
    User existingUser = this.find(id);
    //2. actualizamos el usuario
    existingUser = this.userMapper.UpdateToEntity(request,id);
    existingUser.setId(id);
    //3. devolvemos el usuario actualizado
    return this.userMapper.toResponse(this.userRepository.save(existingUser));
  }

}
