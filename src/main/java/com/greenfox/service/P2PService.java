package com.greenfox.service;

import com.greenfox.model.User;
import com.greenfox.repository.MessageRepository;
import com.greenfox.repository.UserRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class P2PService {

  @Autowired
  MessageRepository messageRepo;

  @Autowired
  UserRepository userRepo;

  public boolean containsUser(String username) {
    List<User> users = new ArrayList<>((Collection)userRepo.findAll());
    int counter = 0;
    for (User oneUser : users) {
      if (oneUser.getUsername().equals(username)) {
        counter++;
      }
    }
    return (counter != 0);
  }

  public boolean isAnyUser() {
    List<User> users = new ArrayList<>((Collection)userRepo.findAll());
    return users.size()== 0;
  }

  public String setUsername(Model model, String username) {
    if (username == "") {
      model.addAttribute("error", "The username field is empty");
      return "enter";
    } else {
      if (isAnyUser()) {
        this.userRepo.save(new User(username));
        return "redirect:/";
      } else {
        if (containsUser(username)) {
          return "redirect:/";
        } else {
          model.addAttribute("error", "Please use valid username");
          return "enter";
        }
      }
    }
  }
}
