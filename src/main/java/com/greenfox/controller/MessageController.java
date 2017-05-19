package com.greenfox.controller;

import com.greenfox.model.ReceivedMessage;
import com.greenfox.service.P2PService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MessageController {

  @Autowired
  P2PService p2PService;

  @RequestMapping("/")
  public String indexSite(Model model) {
    return p2PService.mainPageHandler(model);
  }

  @PostMapping("/")
  public String addMessage(@RequestParam("message") String message) {
    return p2PService.addMessage(message);
  }

  @PutMapping("/")
  public String updateUsername(@RequestParam("username") String user) {
    return p2PService.updateUsername(user);
  }

  @RequestMapping("/enter")
  public String enterPage() {
    return "enter";
  }

  @PostMapping("/enter")
  public String enterMessage(Model model, @RequestParam("username") String user) {
    return p2PService.setUsername(model, user);
  }
}
