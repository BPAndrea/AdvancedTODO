package com.greenfox.myprogram.dto;


public class TodoDTO {

  private String dtoName;
  private boolean isDone = false;
  private boolean isUrgent = false;

  public String getDtoName() {
    return dtoName;
  }

  public void setDtoName(String dtoName) {
    this.dtoName = dtoName;
  }

  public boolean isDone() {
    return isDone;
  }

  public void setDone(boolean done) {
    isDone = done;
  }

  public boolean isUrgent() {
    return isUrgent;
  }

  public void setUrgent(boolean urgent) {
    isUrgent = urgent;
  }
}
