package com.example.todo.service;

import com.example.todo.dto.ToDoListDto;
import com.example.todo.dto.request.ToDoCreateRequestDto;
import com.example.todo.entity.ToDoList;
import com.example.todo.enums.Status;

import java.time.LocalDate;
import java.util.List;

public interface TodoService {

    ToDoListDto create(ToDoCreateRequestDto toDoCreateRequest);
    ToDoListDto update(Long id,ToDoCreateRequestDto toDoUpdateRequest);
    ToDoListDto getById(Long id);
    List<ToDoListDto> getAll();
    void delete(Long id);

    List<ToDoList> findAllByDeadline(LocalDate localDate);
    List<ToDoList> findAllByStatus(Status status);
}
