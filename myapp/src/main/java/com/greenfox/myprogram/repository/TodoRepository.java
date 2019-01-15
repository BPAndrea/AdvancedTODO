package com.greenfox.myprogram.repository;

import com.greenfox.myprogram.model.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {

  List<Todo> findAll();

  void deleteById(Long id);

  Todo findAllById(Long id);

  List<Todo> findAllByNameContainingOrDescriptionContaining(String name, String description);
}
