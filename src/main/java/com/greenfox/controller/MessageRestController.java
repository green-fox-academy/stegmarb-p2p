package com.greenfox.controller;

import com.greenfox.model.ReceivedMessage;
import com.greenfox.service.P2PService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageRestController {

  @Autowired
  P2PService p2PService;

  @PostMapping("/api/message/receive")
  public void receiveMessage(@RequestBody ReceivedMessage message) {
    p2PService.receiveNewMessage(message);
  }
}
