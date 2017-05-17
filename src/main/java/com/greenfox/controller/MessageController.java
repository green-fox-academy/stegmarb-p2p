package com.greenfox.controller;

import com.greenfox.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MessageController {

  @Autowired
  MessageRepository messageRepository;

  @RequestMapping("/")
  public String indexSite() {
    return "index";
  }
}
