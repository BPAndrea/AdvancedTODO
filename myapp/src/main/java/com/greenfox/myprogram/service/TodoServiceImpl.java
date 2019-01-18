package com.greenfox.myprogram.service;

import com.greenfox.myprogram.model.Todo;
import com.greenfox.myprogram.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.rmi.NoSuchObjectException;
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

  public TodoServiceImpl() {
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
 /*   Todo toreturn = todoRepository.findAllById(id);
  if (toreturn == null)
      throw new NoSuchObjectException();*/

   return todoRepository.findAllById(id);
/*    Todo sent = todoRepository.findAllById(id);
    sent.setDescription(null);
    return sent;*/
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
