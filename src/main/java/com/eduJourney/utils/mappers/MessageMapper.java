package com.eduJourney.utils.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eduJourney.api.dto.request.MessageRequest;
import com.eduJourney.api.dto.response.MessageBasicResponse;
import com.eduJourney.domain.entities.Course;
import com.eduJourney.domain.entities.Message;
import com.eduJourney.domain.entities.User;
import com.eduJourney.domain.repositories.CourseRepository;
import com.eduJourney.domain.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MessageMapper {
  @Autowired 
  private final UserRepository userRepository;
  @Autowired
  private final CourseRepository courseRepository;
  public MessageBasicResponse toResponse(Message message) {
    return MessageBasicResponse.builder()
                               .id(message.getId())
                               .content(message.getContent())
                               .date(message.getDate())
                               .build();
  }

  public Message toEntity(MessageRequest request) {
    User sender = userRepository.findById(request.getSenderId()).orElseThrow();
    User recipient = userRepository.findById(request.getCourseId()).orElseThrow();
    Course course = courseRepository.findById(request.getCourseId()).orElseThrow();
    return Message.builder()
                 .content(request.getContent())
                 .date(request.getDate())
                 .recipientId(recipient)
                 .senderId(sender)
                 .course(course)
                 .build();
  
  }
}
