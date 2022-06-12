package com.example.todo.repository;

import com.example.todo.entity.ToDoList;
import com.example.todo.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ToDoRepository extends JpaRepository<ToDoList,Long> {

    List<ToDoList> findAllByDeadline(LocalDate localDate);
    List<ToDoList> findAllByStatusTask(Status status);
}
