package com.example.todo.mapper.impl;

import com.example.todo.dto.ToDoListDto;
import com.example.todo.dto.request.ToDoCreateRequestDto;
import com.example.todo.entity.ToDoList;
import com.example.todo.mapper.ToDoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MapperImpl implements ToDoMapper {



    @Override
    public ToDoListDto mapToDto(ToDoList toDoList) {

        return ToDoListDto.builder()
                .id(toDoList.getId())
                .name(toDoList.getName())
                .deadline(toDoList.getDeadline())
                .task(toDoList.getStatusTask().name())
                .build();
    }

    @Override
    public ToDoList mapToEntity(ToDoCreateRequestDto requestDto) {

        ToDoList toDoList = new ToDoList();
        toDoList.setName(requestDto.getName());
        toDoList.setDeadline(requestDto.getDeadline());
        return toDoList;
    }
}
