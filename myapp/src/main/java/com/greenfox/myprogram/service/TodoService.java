package com.greenfox.myprogram.service;

import com.greenfox.myprogram.model.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TodoService {
  List<Todo> getAll();

  List<Todo> getActive();

  void addItem(Todo todo);

  void deleteItemById(long id);

  Todo findById(Long id);

  Todo updateItem(Todo todo);

  List<Todo> findByNameOrDescription(String keyword);
}
