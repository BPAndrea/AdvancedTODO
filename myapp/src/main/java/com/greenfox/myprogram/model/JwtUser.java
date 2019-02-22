package com.greenfox.myprogram.model;

public class JwtUser {
  private String userName;
  private long id;
  private String role;
  private long exp;

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getUserName() {
    return userName;
  }

  public long getId() {
    return id;
  }

  public String getRole() {
    return role;
  }

  public long getExp() {
    return exp;
  }

  public void setExp(long exp) {
    this.exp = exp;
  }
}
