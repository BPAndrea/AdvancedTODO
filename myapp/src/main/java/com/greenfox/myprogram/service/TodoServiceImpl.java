package com.greenfox.myprogram.service;

import com.greenfox.myprogram.model.Todo;
import com.greenfox.myprogram.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService {
  private TodoRepository todoRepository;

  @Autowired
  public TodoServiceImpl(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  @Override
  public List<Todo> getAll() {
    return (List<Todo>) todoRepository.findAll();
  }

  @Override
  public List<Todo> getActive() {
    List<Todo> active = new ArrayList<>();
    active = todoRepository.findAll().stream().
        filter(item -> !item.isDone()).collect(Collectors.toList());
    return active;
  }

  @Override
  public void addItem(Todo todo) {
    if (todo != null) {
      todoRepository.save(todo);
    }
  }

  @Override
  public void deleteItemById(long id) {
    todoRepository.deleteById(id);
  }

  @Override
  public Todo findById(Long id) {
    return todoRepository.findAllById(id);
  }

  @Override
  public Todo updateItem(Todo todo) {
    return todoRepository.save(todo);
  }

  @Override
  public List<Todo> findByNameOrDescription(String keyword) {
    return todoRepository.findAllByNameContainingOrDescriptionContaining(keyword, keyword);
  }

}
