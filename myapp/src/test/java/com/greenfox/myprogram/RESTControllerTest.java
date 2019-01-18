package com.greenfox.myprogram;

import com.greenfox.myprogram.controller.RESTController;
import com.greenfox.myprogram.model.Todo;
import com.greenfox.myprogram.service.TodoService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RESTControllerTest {

  @InjectMocks
  RESTController restController;

  @Mock
  TodoService todoService;

  List<Todo> serviceList;

  @BeforeEach
  void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testApiList() {
    serviceList = new ArrayList<>();
    Todo mocktodo = new Todo();
    mocktodo.setId(1L);
    mocktodo.setName("Testobject");
    mocktodo.setDescription("Mock description");
    mocktodo.setDone(true);
    mocktodo.setUrgent(false);

    Todo mocktodo2 = new Todo();
    mocktodo2.setId(2L);
    mocktodo.setName("Testobject2");
    mocktodo.setDescription("Mock description2");
    mocktodo.setDone(true);
    mocktodo.setUrgent(false);

    serviceList.add(mocktodo);
    serviceList.add(mocktodo2);

    when(todoService.getAll()).thenReturn(serviceList);

    List<Todo> controllerList = new ArrayList<>();
    controllerList = restController.apiList();

    assertNotNull(controllerList);
    assertEquals(serviceList.get(0).getDescription(), controllerList.get(0).getDescription());
    assertTrue(serviceList.size() == controllerList.size());

  }
}

