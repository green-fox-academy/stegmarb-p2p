package com.greenfox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class PeertopeerApplication {

	public static void main(String[] args) {
    SpringApplication.run(PeertopeerApplication.class, args);
    System.out.println(System.getenv("CHAT_APP_LOGLEVEL"));
    System.out.println(System.getenv("CHAT_APP_UNIQUE_ID"));
  }
}
