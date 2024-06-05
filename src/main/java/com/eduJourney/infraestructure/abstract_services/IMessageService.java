package com.eduJourney.infraestructure.abstract_services;

import java.util.List;
import java.util.UUID;

import com.eduJourney.api.dto.request.MessageRequest;
import com.eduJourney.api.dto.response.MessageBasicResponse;
import com.eduJourney.domain.entities.Message;

public interface IMessageService extends CrudService<MessageRequest,MessageBasicResponse,UUID>{
  
  public List<MessageBasicResponse> getMessagesBySenderAndReceiver(UUID senderId, UUID receiverId);
  
  public List<MessageBasicResponse> getMessagesByCourseId(UUID courseId);
}
