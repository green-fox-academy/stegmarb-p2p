package com.greenfox.controller;

import com.greenfox.model.User;
import com.greenfox.repository.MessageRepository;
import com.greenfox.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
    List<User> users = new ArrayList<>((Collection) user.findAll());
    model.addAttribute("currentUser", users);
    return "enter";
  }

  @RequestMapping(value = "/enter", method = RequestMethod.POST)
  public String enterMessage(Model model, @RequestParam("username") String user) {
    if (user == "") {
      model.addAttribute("error", "The username field is empty");
      return "enter";
    } else {
    this.user.save(new User(user));
      return "redirect:/";
  }
 }
}
