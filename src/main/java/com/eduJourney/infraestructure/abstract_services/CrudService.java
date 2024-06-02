package com.eduJourney.infraestructure.abstract_services;

import org.springframework.data.domain.Page;

public interface CrudService <RQ,RS,ID>{
  public RS create(RQ request);
  
  public Page<RS> getAll(int page , int size );
  public void delete(ID id);
  public RS getById(ID id);
}
