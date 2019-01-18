package com.greenfox.myprogram;

import com.greenfox.myprogram.model.Todo;
import com.greenfox.myprogram.repository.TodoRepository;
import com.greenfox.myprogram.service.TodoService;
import com.greenfox.myprogram.service.TodoServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TodoServiceTest {

  @Mock
  private TodoRepository todoRepository;

  @InjectMocks
   private TodoServiceImpl todoService;

  @BeforeEach
  void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testFindById() {

    Todo mocktodo = new Todo();
    mocktodo.setId(1L);
    mocktodo.setName("Testobject");
    mocktodo.setDescription("Mock description");
    mocktodo.setDone(true);
    mocktodo.setUrgent(false);
    //mocktodo.setTimestamp(2019-01-15 22:04:47.0);

    when(todoRepository.findAllById(anyLong())).thenReturn(mocktodo);

    Todo resultFromService = todoService.findById(1L);

    assertNotNull(resultFromService);
    assertEquals("Testobject", resultFromService.getName());
    assertEquals("Mock description", resultFromService.getDescription());
    assertTrue(resultFromService.isDone());
    assertFalse(resultFromService.isUrgent());

  }
  @Test
  public void testFindByNameOrDescription() {
    List<Todo> foundItems = new ArrayList<>();
    Todo mocktodo2 = new Todo();
    mocktodo2.setId(1L);
    mocktodo2.setName("Testobject");
    mocktodo2.setDescription("Mock description");
    mocktodo2.setDone(true);
    mocktodo2.setUrgent(false);

    Todo mocktodo = new Todo();
    mocktodo.setId(4L);
    mocktodo.setName("Testobject 4 ");
    mocktodo.setDescription("Mock description 2");
    mocktodo.setDone(true);
    mocktodo.setUrgent(false);

    foundItems.add(mocktodo);
    foundItems.add(mocktodo2);

    when(todoRepository.findAllByNameContainingOrDescriptionContaining(anyString(),anyString())).thenReturn(foundItems);

    List<Todo> resultFromService = todoService.findByNameOrDescription(anyString());

    assertNotNull(resultFromService);
    assertEquals(foundItems.get(1).getName(), resultFromService.get(1).getName());
    assertTrue(foundItems.size() == resultFromService.size());
  }
}
