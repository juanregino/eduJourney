package com.eduJourney.infraestructure.abstract_services;

public interface CrudService <RQ,RS,ID>{
  public RS create(RQ request);
  public RS update(RQ request);
  public RS getAll(ID id);
  public RS delete(ID id);
  public RS getById(ID id);
}
