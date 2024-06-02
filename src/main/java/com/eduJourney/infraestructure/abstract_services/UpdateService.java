package com.eduJourney.infraestructure.abstract_services;

public interface UpdateService <RQ,RS,ID>{
  public RS update(RQ request, ID id);
  
}
