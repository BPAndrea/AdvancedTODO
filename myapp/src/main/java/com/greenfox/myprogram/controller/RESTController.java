package com.greenfox.myprogram.controller;

import com.greenfox.myprogram.model.Todo;
import com.greenfox.myprogram.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
  public List<Todo> apiList() {
    return todoService.getAll();
  }


  @PostMapping("/api/add")
  public Object apiAddTodo(@RequestBody Todo todo) {
    if (todo != null) {
      todoService.addItem(todo);
      return todoService.getAll();
    } else {
      return HttpStatus.BAD_REQUEST;
    }
  }

}
