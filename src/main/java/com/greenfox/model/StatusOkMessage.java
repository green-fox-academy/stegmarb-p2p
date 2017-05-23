package com.greenfox.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatusOkMessage {
  private String status;

  public StatusOkMessage() {
    status = "ok";
  }
}
