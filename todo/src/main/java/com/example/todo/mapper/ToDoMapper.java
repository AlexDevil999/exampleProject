package com.example.todo.mapper;

import com.example.todo.dto.ToDoListDto;
import com.example.todo.dto.request.ToDoCreateRequestDto;
import com.example.todo.entity.ToDoList;

public interface ToDoMapper {

    ToDoListDto mapToDto(ToDoList toDoList);
    ToDoList mapToEntity(ToDoCreateRequestDto requestDto);
}
