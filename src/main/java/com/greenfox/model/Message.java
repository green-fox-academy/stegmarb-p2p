package com.greenfox.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Getter
@Setter
public class Message {
  @Id
  private long id;
  private String userName;
  private String message;
  private Timestamp timestamp;

  public Message() {
    this.id = ((long) (Math.random()*8999999)+1000000);
    this.timestamp = new Timestamp(new Date().getTime());
//    this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
  }

  public Message(String userName, String message) {
    this.id = ((long) (Math.random()*8999999)+1000000);
    this.userName = userName;
    this.message = message;
    this.timestamp = new Timestamp(new Date().getTime());
  }
}
