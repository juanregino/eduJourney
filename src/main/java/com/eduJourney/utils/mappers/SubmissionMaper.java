package com.eduJourney.utils.mappers;

import org.springframework.stereotype.Component;

import com.eduJourney.api.dto.request.SubmissionRequest;
import com.eduJourney.api.dto.response.SubmissionBasicResponse;
import com.eduJourney.domain.entities.Submission;

@Component
public class SubmissionMaper {
   public SubmissionBasicResponse toResponse(Submission entity){
     return SubmissionBasicResponse.builder()
                                   .id(entity.getId())
                                   .content(entity.getContent())
                                   .date(entity.getDate())
                                   .grade(entity.getGrade())
                                   .build();
   }
   public Submission toEntity(SubmissionRequest request){
   
     return Submission.builder()
                      .content(request.getContent())
                      .date(request.getDate())
                      .grade(request.getGrade())
                      .build();
  }
}
