package com.greenfox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MessageController {
  @RequestMapping("/")
  public String indexSite() {
    return "index";
  }
}