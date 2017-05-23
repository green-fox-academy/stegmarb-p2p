package com.greenfox.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MissingError extends StatusOkMessage{
  private String message;

  public MissingError(String message) {
    super();
    this.message = message;
  }
}
