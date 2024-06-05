package com.eduJourney.utils.mappers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eduJourney.api.dto.request.SubmissionRequest;
import com.eduJourney.api.dto.request.update.SubmissionUpdateRequest;
import com.eduJourney.api.dto.response.SubmissionBasicResponse;
import com.eduJourney.domain.entities.Assignment;
import com.eduJourney.domain.entities.Submission;
import com.eduJourney.domain.entities.User;
import com.eduJourney.domain.repositories.AssignmentRepository;
import com.eduJourney.domain.repositories.SubmissionRepository;
import com.eduJourney.domain.repositories.UserRepository;
import com.eduJourney.utils.exceptions.BadRequestException;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SubmissionMaper {
  @Autowired
  private final UserRepository userRepository;
  @Autowired
  private final SubmissionRepository submissionRepository;
  @Autowired 
  private final AssignmentRepository assignmentRepository;
   public SubmissionBasicResponse toResponse(Submission entity){
     return SubmissionBasicResponse.builder()
                                   .id(entity.getId())
                                   .content(entity.getContent())
                                   .date(entity.getDate())
                                   .grade(entity.getGrade())
                                   .build();
   }
   public Submission toEntity(SubmissionRequest request){
    User user = this.userRepository.findById(request.getUserId()).orElseThrow(()-> new BadRequestException("User not found")); 
    Assignment  assignment = this.assignmentRepository.findById(request.getAssignmentId()).orElseThrow(()-> new BadRequestException("Assignment not found"));
     return Submission.builder()
                      .content(request.getContent())
                      .date(request.getDate())
                      .grade(request.getGrade())
                      .user(user)
                      .assignment(assignment)
                      .build();
  }

  public Submission UpdateToEntity(SubmissionUpdateRequest request, UUID id){
    Submission submission = this.submissionRepository.findById(id).orElseThrow(()-> new BadRequestException("Submission not found"));
    submission.setContent(request.getContent());
    submission.setGrade(request.getGrade());
    return submission;
  }
}
