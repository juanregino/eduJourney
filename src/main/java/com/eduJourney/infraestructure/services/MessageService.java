package com.eduJourney.infraestructure.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.eduJourney.api.dto.request.MessageRequest;
import com.eduJourney.api.dto.response.MessageBasicResponse;
import com.eduJourney.domain.entities.Course;
import com.eduJourney.domain.entities.Message;
import com.eduJourney.domain.entities.User;
import com.eduJourney.domain.repositories.CourseRepository;
import com.eduJourney.domain.repositories.MessageRepository;
import com.eduJourney.domain.repositories.UserRepository;
import com.eduJourney.infraestructure.abstract_services.IMessageService;
import com.eduJourney.utils.mappers.MessageMapper;

@Service
public class MessageService implements IMessageService {
@Autowired
private MessageMapper messageMapper;
@Autowired
private MessageRepository messageRepository;
@Autowired
private CourseRepository courseRepository;
@Autowired
private UserRepository userRepository;
  @Override
  public MessageBasicResponse create(MessageRequest request) {
    Message message = this.messageMapper.toEntity(request);
    return this.messageMapper.toResponse(this.messageRepository.save(message));
  }
  @Override
  public void delete(UUID id) {
    
    
  }

  @Override
  public Page<MessageBasicResponse> getAll(int page, int size) {
    
    return null;
  }

  @Override
  public MessageBasicResponse getById(UUID id) {
    
    return null;
  }
@Override
  public List<MessageBasicResponse> getMessagesBySenderAndReceiver(UUID senderId, UUID receiverId) {
    User sender = this.userRepository.findById(senderId).orElseThrow();
    User receiver = this.userRepository.findById(receiverId).orElseThrow();
    List<Message> messages = messageRepository.findBySenderIdAndReceiverId(sender, receiver); 
    List<MessageBasicResponse> responseList = new ArrayList<>();
    for (Message message : messages) {
      responseList.add(messageMapper.toResponse(message));
    }

    return responseList;
  }
@Override
  public List<MessageBasicResponse> getMessagesByCourseId(UUID courseId) {
    Course course = this.courseRepository.findById(courseId).orElseThrow();
   List<Message> messages = messageRepository.findByCourseId(course);
        List<MessageBasicResponse> responseList = new ArrayList<>();
        for (Message message : messages) {
            responseList.add(messageMapper.toResponse(message));
        }

        return responseList;

  }
  
}
