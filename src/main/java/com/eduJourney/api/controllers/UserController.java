package com.eduJourney.api.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eduJourney.api.dto.request.UserRequest;
import com.eduJourney.api.dto.request.update.UserUpdateRequest;
import com.eduJourney.api.dto.response.UserBasicResponse;
import com.eduJourney.infraestructure.abstract_services.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private IUserService userService;

  @GetMapping
  public ResponseEntity<Page<UserBasicResponse>> getAll(
    @RequestParam(defaultValue = "1") int page,
    @RequestParam(defaultValue = "10") int size) {
  
    return ResponseEntity.ok(this.userService.getAll(page - 1, size));
  }

  @PostMapping
  public ResponseEntity<UserBasicResponse> createUser(@Validated @RequestBody UserRequest request){
    UserBasicResponse user = this.userService.create(request);
    return ResponseEntity.ok(user);
  }

  @PutMapping("/{id}")
  public ResponseEntity<UserBasicResponse> updateUser(@PathVariable UUID id, @Validated @RequestBody UserUpdateRequest request){
  
    return ResponseEntity.ok(this.userService.update(request,id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable UUID id){
    this.userService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
