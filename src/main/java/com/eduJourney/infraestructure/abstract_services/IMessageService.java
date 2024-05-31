package com.eduJourney.infraestructure.abstract_services;

import java.util.UUID;

import com.eduJourney.api.dto.request.MessageRequest;
import com.eduJourney.api.dto.response.MessageBasicResponse;

public interface IMessageService extends CrudService<MessageRequest,MessageBasicResponse,UUID>{
  
}
