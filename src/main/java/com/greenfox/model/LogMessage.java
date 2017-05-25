package com.greenfox.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Getter
@Setter
public class LogMessage {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String path;
  private String method;
  private Timestamp dateAndTime;
  private String logLevel;


  public LogMessage() {

  }
}
