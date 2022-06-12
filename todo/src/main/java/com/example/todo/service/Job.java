package com.example.todo.service;

import com.example.todo.entity.ToDoList;
import com.example.todo.enums.Status;
import com.example.todo.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Job {

    private final ToDoRepository toDoRepository;

    @Scheduled(cron = "${time.cron}")
    void job(){
        List<ToDoList> firstlist = toDoRepository.findAll();
        List<ToDoList> lastList = new ArrayList<>();

        for (ToDoList todo : firstlist){

            if(todo.getDeadline().equals(LocalDate.now())){
                todo.setStatusTask(Status.OVERDUE);
                lastList.add(todo);
            }
        }
        toDoRepository.saveAll(lastList);
    }
}
