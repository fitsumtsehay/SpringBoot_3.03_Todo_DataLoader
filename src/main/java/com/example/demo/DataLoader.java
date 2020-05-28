package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    TodoListRepository todoListRepository;

    @Override
    public void run(String...strings) throws Exception{
        TodoList tasks;
        tasks = new TodoList();

        tasks.setName("Clean Windows");
        tasks.setPriority("High");
        tasks.setDate(LocalDate.of(2020, 05, 28));
        todoListRepository.save(tasks);
    }
}
