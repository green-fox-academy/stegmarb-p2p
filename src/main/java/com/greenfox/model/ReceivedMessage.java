package com.greenfox.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class ReceivedMessage {
  private Message message;
  private Client client;

  public ReceivedMessage() {
  }

  public ReceivedMessage(Message message, Client client) {
    this.message = message;
    this.client = client;
  }
}
