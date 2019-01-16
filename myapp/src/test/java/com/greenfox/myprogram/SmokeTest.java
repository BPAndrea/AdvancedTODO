package com.greenfox.myprogram;

import com.greenfox.myprogram.controller.TodoController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {

  @Autowired
  private TodoController todoController;

  @Test
  public void controllerLoads() throws Exception {
    assertThat(todoController).isNotNull();
  }
}

