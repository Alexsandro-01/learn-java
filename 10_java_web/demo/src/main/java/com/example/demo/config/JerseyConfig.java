package com.example.demo.config;

import com.example.demo.application.BookController;
import org.springframework.stereotype.Component;
import org.glassfish.jersey.server.ResourceConfig;
@Component
public class JerseyConfig extends ResourceConfig {
  public JerseyConfig() {
    register(BookController.class);
  }
}
