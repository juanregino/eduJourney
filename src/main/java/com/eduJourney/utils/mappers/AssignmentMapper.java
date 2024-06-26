package com.eduJourney.utils.mappers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eduJourney.api.dto.request.AssignmentRequest;
import com.eduJourney.api.dto.request.update.AssignmentUpdateRequest;
import com.eduJourney.api.dto.response.AssignmentBasicResponse;
import com.eduJourney.domain.entities.Assignment;
import com.eduJourney.domain.entities.Lesson;
import com.eduJourney.domain.repositories.AssignmentRepository;
import com.eduJourney.domain.repositories.LessonRepository;
import com.eduJourney.utils.exceptions.BadRequestException;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AssignmentMapper {
  @Autowired
  private final LessonRepository lessonRepository;
  @Autowired
  private final AssignmentRepository assignmentRepository;          
  public AssignmentBasicResponse toResponse (Assignment entity){
    return AssignmentBasicResponse.builder()
                                  .id(entity.getId())
                                  .title(entity.getTitle())
                                  .description(entity.getDescription())
                                  .dueDate(entity.getDueDate())
                                  .build();
  }

  public Assignment toEntity( AssignmentRequest request){
    Lesson lesson = this.lessonRepository.findById(request.getLessonId()).orElseThrow(() -> new RuntimeException("Lesson not found"));  
    return Assignment.builder()
                     .title(request.getTitle())
                     .description(request.getDescription())
                     .dueDate(request.getDueDate())
                     .lesson(lesson)
                     .build();
  }
  public Assignment UpdateToEntity(AssignmentUpdateRequest request, UUID id){
     Assignment assignment = this.assignmentRepository.findById(id).orElseThrow(() -> new BadRequestException("Assignment not found"));
     Lesson lesson = this.lessonRepository.findById(assignment.getLesson().getId()).orElseThrow(()-> new BadRequestException("Lesson not found "));
     return Assignment.builder()
     .title(request.getTitle())
     .description(request.getDescription())
     .dueDate(request.getDueDate())
     .lesson(lesson)
     .build();
    }
}
