package com.greenfox.model;

import com.greenfox.repository.LogMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogMessageService {

  @Autowired
  private LogMessageRepository logMess;


}
