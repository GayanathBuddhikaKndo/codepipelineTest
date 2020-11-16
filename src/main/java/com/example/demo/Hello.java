package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Hello {
  @GetMapping()
  public String hello() {
    return "Hello world";
  }

  @GetMapping("/json")
  public HelloGaya json() {
    return new HelloGaya("gayanth", "27");
  }

  private class HelloGaya {
    private String name;
    private String age;

    public HelloGaya(String name, String age) {
      this.name = name;
      this.age = age;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getAge() {
      return age;
    }

    public void setAge(String age) {
      this.age = age;
    }
  }
}
