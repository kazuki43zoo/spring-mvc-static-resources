package com.example.component.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping(path = "/")
  String home() {
    return "index";
  }
}
