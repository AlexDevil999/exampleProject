package com.example.todo.service.impl;

import com.example.todo.dto.ToDoListDto;
import com.example.todo.dto.request.ToDoCreateRequestDto;
import com.example.todo.entity.ToDoList;
import com.example.todo.enums.Status;
import com.example.todo.mapper.ToDoMapper;
import com.example.todo.repository.ToDoRepository;
import com.example.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TodoServiceImpl implements TodoService {

    private final ToDoRepository toDoRepository;
    private final ToDoMapper toDoMapper;

    @Override
    public ToDoListDto create(ToDoCreateRequestDto toDoCreateRequest) {

        ToDoList toDoList = toDoMapper.mapToEntity(toDoCreateRequest);

        toDoList.setCreatedAt(LocalDateTime.now());

        if(toDoCreateRequest.getDeadline() == null) {
            toDoList.setStatusTask(Status.UNLIMITED);
        } else {
            toDoList.setStatusTask(Status.ACTIVE);
        }

        return toDoMapper.mapToDto(toDoRepository.save(toDoList));
    }

    @Override
    public ToDoListDto update(Long id, ToDoCreateRequestDto toDoUpdateRequest) {

        Optional<ToDoList> toDoList = toDoRepository.findById(id);

        if(toDoList.isPresent()){
            toDoList.get().setName(toDoUpdateRequest.getName());
            toDoList.get().setDeadline(toDoUpdateRequest.getDeadline());
        }

        return toDoMapper.mapToDto(toDoRepository.save(toDoList.get()));
    }

    @Override
    public ToDoListDto getById(Long id) {

        Optional<ToDoList> toDoList = toDoRepository.findById(id);

        if(toDoList.isPresent()){
            return toDoMapper.mapToDto(toDoList.get());
        }
        return null;
    }

    @Override
    public List<ToDoListDto> getAll() {
        return toDoRepository.findAll().stream().map(list -> toDoMapper.mapToDto(list)).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        Optional<ToDoList> toDoList = toDoRepository.findById(id);

        if(toDoList.isPresent()){
            toDoList.get().setStatusTask(Status.NO_ACTIVE);
            toDoRepository.save(toDoList.get());
        }
    }

    @Override
    public List<ToDoList> findAllByDeadline(LocalDate localDate) {
            return toDoRepository.findAllByDeadline(localDate);
    }

    @Override
    public List<ToDoList> findAllByStatus(Status status) {


        return toDoRepository.findAllByStatusTask(status);
    }
}
