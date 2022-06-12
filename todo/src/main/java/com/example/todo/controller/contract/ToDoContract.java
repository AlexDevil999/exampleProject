package com.example.todo.controller.contract;

import com.example.todo.dto.ToDoListDto;
import com.example.todo.dto.request.FilterRequestDto;
import com.example.todo.dto.request.ToDoCreateRequestDto;
import com.example.todo.entity.ToDoList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ToDoContract {

    ResponseEntity<ToDoListDto> create(@RequestBody ToDoCreateRequestDto toDoCreateRequest);
    ResponseEntity<ToDoListDto> update(@PathVariable Long id, @RequestBody ToDoCreateRequestDto toDoUpdateRequest);
    ResponseEntity<ToDoListDto> getById(@PathVariable Long id);
    List<ToDoListDto> getAll();
    void delete(@PathVariable Long id);
}
