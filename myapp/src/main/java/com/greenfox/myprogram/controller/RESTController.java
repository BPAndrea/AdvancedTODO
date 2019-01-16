package com.greenfox.myprogram.controller;

import com.greenfox.myprogram.model.Todo;
import com.greenfox.myprogram.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RESTController {
  private TodoService todoService;

  @Autowired
  public RESTController(TodoService todoService) {
    this.todoService = todoService;
  }

  @GetMapping("/api")
  public List<Todo> apiList(@RequestParam(value = "isActive", required = false) boolean isActive, Model model) {
    if (isActive) {
      return todoService.getActive();
    } else {
      return todoService.getAll();
    }
  }

  @PostMapping("/api/add")
  public List<Todo> apiAddTodo(@RequestBody Todo todo) {
    todoService.addItem(todo);
    return todoService.getAll();
  }

}
