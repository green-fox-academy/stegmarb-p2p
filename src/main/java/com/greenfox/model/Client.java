package com.greenfox.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Client {
  private String id;

  public Client() {
  }

  public Client(String id) {
    this.id = id;
  }
}
