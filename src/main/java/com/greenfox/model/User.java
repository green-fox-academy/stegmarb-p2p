package com.greenfox.model;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String username;

  public User() {
  }

  public User(String username) {
    this.username = username;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
