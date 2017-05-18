package com.greenfox.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Getter
@Setter
public class Message {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String userName;
  private String message;
  private String date;

  public Message() {
    this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
  }

  public Message(String userName, String message) {
    this.userName = userName;
    this.message = message;
    this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
  }
}
