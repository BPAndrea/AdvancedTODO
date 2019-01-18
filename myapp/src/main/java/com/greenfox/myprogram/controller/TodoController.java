package com.greenfox.myprogram.controller;

import com.greenfox.myprogram.model.Todo;
import com.greenfox.myprogram.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TodoController {
  private TodoService todoService;

  @Autowired
  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }


  @GetMapping({"/", "/list"})
  public String list(@RequestParam(value = "isActive", required = false) boolean isActive, Model model) {
    model.addAttribute("item", new Todo());
    if (isActive) {
      model.addAttribute("items", todoService.getActive());
    } else {
      model.addAttribute("items", todoService.getAll());
    }
    return "todo/index";
  }

  @GetMapping("/add")
  public String addForm(Model model) {
    model.addAttribute("item", new Todo());
    return "todo/add";
  }

  @PostMapping("/add")
  public String addElement(Todo todo) {
    todoService.addItem(todo);
    return "redirect:/";
  }

  @GetMapping("/{id}/delete")
  public String deleteElement(@PathVariable long id) {
    todoService.deleteItemById(id);
    return "redirect:/";
  }

  @GetMapping("/{id}/edit")
  public String getItem(@PathVariable long id, Model model) {
    model.addAttribute("item", todoService.findById(id));
    return "todo/edit_todo";
  }

  @PostMapping("/{id}/edit")
  public String updateItem(Todo todo) {
    todoService.updateItem(todo);
    return "redirect:/";
  }

  @GetMapping("/{id}/item")
  public String showItem(@PathVariable long id, Model model) {
    model.addAttribute("item", todoService.findById(id));
    return "todo/todo";
  }

  @PostMapping("/todo/search")
  public String searchTodo(@RequestParam("name") String name, Model model) {
    List<Todo> result = todoService.findByNameOrDescription(name);
    if (result.size() == 0) {
      model.addAttribute("queryResult", "No todos found with the given name (title or description)");
    } else {
      model.addAttribute("queryResult", name + " was found in the Todo list:");
      model.addAttribute("foundItems", result);
    }
    return "todo/search";
  }
}

