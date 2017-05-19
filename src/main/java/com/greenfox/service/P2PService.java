package com.greenfox.service;

import com.greenfox.model.Message;
import com.greenfox.model.ReceivedMessage;
import com.greenfox.model.User;
import com.greenfox.repository.MessageRepository;
import com.greenfox.repository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Getter
@Setter
public class P2PService {

  @Autowired
  private MessageRepository messageRepo;

  @Autowired
  private UserRepository userRepo;

  @Autowired
  private ReceivedMessage recMess;
  private String currentUser;
  private List<Message> messages = new ArrayList<>();

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
    return users.size() == 0;
  }

  public String setUsername(Model model, String username) {
    if (username == "") {
      model.addAttribute("error", "The username field is empty");
      return "enter";
    } else {
      if (isAnyUser()) {
        this.userRepo.save(new User(username));
        currentUser = username;
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

  public String updateUsername(String name) {
    List<User> users = new ArrayList<>((Collection)userRepo.findAll());
    Long id = new Long(0);
    for (User oneUser : users) {
      if (oneUser.getUsername().equals(currentUser)) {
        id = oneUser.getId();
      }
      User user = userRepo.findOne(id);
      user.setUsername(name);
      userRepo.save(user);
      currentUser = name;
    }
    return "redirect:/";
  }

  public String mainPageHandler(Model model) {
    if (isAnyUser()) {
      return "redirect:/enter";
    } else {
      List<Message> reversedOrderMessages = new ArrayList<>();
      for (int i = messages.size() - 1; i >= 0; i--) {
        reversedOrderMessages.add(messages.get(i));
      }
      model.addAttribute("currentUser", getCurrentUser());
      model.addAttribute("messages", reversedOrderMessages);
      return "index";
    }
  }

  public String addMessage(String message) {
    messageRepo.save(new Message(getCurrentUser(), message));
    messages.add(new Message(getCurrentUser(), message));
    return "redirect:/";
  }

  public void receiveNewMessage(ReceivedMessage newMessage) {
    System.out.println(newMessage.getMessage());
    messageRepo.save(newMessage.getMessage());
    messages.add(newMessage.getMessage());

  }
}
