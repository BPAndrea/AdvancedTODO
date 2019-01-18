package com.greenfox.myprogram.model;

import com.greenfox.myprogram.dto.TodoDTO;
import com.sun.xml.internal.bind.v2.TODO;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;


public class ModelmapperApplication {

  public static void main(String[] args) {
    simpleModelmapping();
  }

  private static void simpleModelmapping() {
    Todo sourceTodo = new Todo("Creating model mapping", true);
    TodoDTO targetTodoDTO = new TodoDTO();
    ModelMapper modelMapper = new ModelMapper();

    modelMapper.map(sourceTodo, targetTodoDTO);
    System.out.println(targetTodoDTO.getDtoName());
    System.out.println(targetTodoDTO.isDone());
    System.out.println(targetTodoDTO.isUrgent());

  }

}
