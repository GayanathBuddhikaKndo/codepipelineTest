package com.example.demo;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class HelloControllerTest {

  @Autowired private MockMvc mockMvc;

  @Test
  public void whenReturnInvalidString() throws Exception {

    mockMvc
        .perform(get("/hello"))
        .andExpect(status().isOk())
        .andExpect(content().string("Hello world"));
  }

  @Test
  public void jasonTest() throws Exception {
    mockMvc
        .perform(get("/hello/json"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name", Matchers.is("gayanth")))
        .andExpect(jsonPath("$.age", Matchers.is("27")));
  }
}
