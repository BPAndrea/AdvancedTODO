package com.greenfox.myprogram.model;

import com.greenfox.myprogram.dto.TodoDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

public class ExplicitModelMapping {

    public static void main(String[] args) {
      explicitModelMappingDemo();
    }

    private static void explicitModelMappingDemo() {
      Todo sourceTodo = new Todo("Creating model mapping", true);

      TodoDTO targetTodoDTO = new TodoDTO();
      ModelMapper modelMapper =new ModelMapper();

      modelMapper.addMappings(new PropertyMap<Todo, TodoDTO>() {
        protected void configure() {
          map().setDtoName(source.getName());
        }
      });

      modelMapper.map(sourceTodo, targetTodoDTO);

      System.out.println(targetTodoDTO.getDtoName());
      System.out.println(targetTodoDTO.isDone());
      System.out.println(targetTodoDTO.isUrgent());
    }
  }
