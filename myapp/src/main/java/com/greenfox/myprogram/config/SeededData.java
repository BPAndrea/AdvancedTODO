package com.greenfox.myprogram.config;

import com.greenfox.myprogram.model.Todo;
import com.greenfox.myprogram.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(value = {"test", "prod"})
public class SeededData implements CommandLineRunner {
    private TodoRepository todoRepository;

    @Autowired
    public SeededData(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Value("${spring.datasource.url}")
    private String dbname;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("****************************" + dbname);
        todoRepository.save(new Todo("xmas", false, true));
        todoRepository.save(new Todo("added new one", true, true));
        todoRepository.save(new Todo("created second", false, true));
        todoRepository.save(new Todo("new year's eve", true, true));
        todoRepository.save(new Todo("ori exam", false, true));
        todoRepository.save(new Todo("ori exam", false, true));
        todoRepository.save(new Todo("foundation exam", true, true));
        todoRepository.save(new Todo("homework", false, false));
    }
}