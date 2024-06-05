package com.eduJourney.api.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eduJourney.api.dto.request.MessageRequest;
import com.eduJourney.api.dto.response.MessageBasicResponse;
import com.eduJourney.infraestructure.abstract_services.IMessageService;

@RestController
@RequestMapping("/messages")
public class MessageController {
  @Autowired
  private IMessageService messageService;

  @PostMapping
  public ResponseEntity<MessageBasicResponse> createMessage(@Validated @RequestBody  MessageRequest request){
    return ResponseEntity.ok(this.messageService.create(request));
  }
   @GetMapping("/{course_id}")
    public List<MessageBasicResponse> getMessagesByCourseId(@PathVariable UUID courseId) {
        return this.messageService.getMessagesByCourseId(courseId);
    }

     @GetMapping("/messages")
    public List<MessageBasicResponse> getMessagesBySenderAndReceiver(
            @RequestParam("sender_id") UUID senderId, 
            @RequestParam("receiver_id") UUID receiverId) {
        return messageService.getMessagesBySenderAndReceiver(senderId, receiverId);
    }
}
