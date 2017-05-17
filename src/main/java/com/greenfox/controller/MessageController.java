package com.greenfox.controller;

import com.greenfox.model.User;
import com.greenfox.repository.MessageRepository;
import com.greenfox.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MessageController {

  @Autowired
  MessageRepository messageRepository;

  @Autowired
  UserRepository user;

  @RequestMapping("/")
  public String indexSite() {
    return "index";
  }

  @RequestMapping("/enter")
  public String enterPage(Model model) {
    model.addAttribute("currentUser", user.findAll());
    return "enter";
  }

  @RequestMapping(value = "/enter", method = RequestMethod.POST)
  public String enterMessage(@RequestParam("username") String user) {
    this.user.save(new User(user));
    return "redirect:/";
  }
}
