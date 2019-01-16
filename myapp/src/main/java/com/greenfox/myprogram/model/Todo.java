package com.greenfox.myprogram.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Todo {
  @Id
  @GeneratedValue
  private long id;
  private String name;
  private String description = "";
  @CreationTimestamp
  private Date timestamp;
  private boolean isDone = false;
  private boolean isUrgent = false;

 // @ManyToOne(fetch = FetchType.LAZY)
 // private Assignee assignee = new Assignee("Nobody", "no email", (long) 1);

  public Todo() {
  }

  public Todo(String name) {
    this.name = name;
  }

  public Todo(String name, boolean isDone) {
    this();
    this.name = name;
    this.isDone = isDone;
  }


/*  public Todo(String name, boolean isDone, boolean isUrgent, Assignee assignee) {
    this();
    this.name = name;
    this.isDone = isDone;
    this.isUrgent = isUrgent;
    this.assignee = assignee;
  }*/

 /* public Assignee getAssignee() {
    return assignee;
  }

 public void setAssignee(Assignee assignee) {
    this.assignee = assignee;
  }*/

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
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

