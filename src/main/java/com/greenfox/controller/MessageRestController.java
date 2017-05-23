package com.greenfox.controller;

import com.greenfox.model.MissingError;
import com.greenfox.model.ReceivedMessage;
import com.greenfox.service.P2PService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MessageRestController {

  @Autowired
  P2PService p2PService;

  @CrossOrigin("*")
  @PostMapping("/api/message/receive")
  public MissingError receiveMessage(@RequestBody ReceivedMessage message) throws IOException {
    p2PService.receiveNewMessage(message);
    return new MissingError("error", p2PService.missingSomething(message));
  }
}
