package com.example.todo.controller;

import com.example.todo.controller.contract.ToDoContract;
import com.example.todo.dto.ToDoListDto;
import com.example.todo.dto.request.FilterRequestDto;
import com.example.todo.dto.request.ToDoCreateRequestDto;
import com.example.todo.entity.ToDoList;
import com.example.todo.enums.Status;
import com.example.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/todo")
public class ToDoController implements ToDoContract {

    private final TodoService todoService;

    @Override
    @PostMapping("/create")
    public ResponseEntity<ToDoListDto> create(@RequestBody ToDoCreateRequestDto toDoCreateRequest) {
        if(toDoCreateRequest != null) {
            return ResponseEntity.ok(todoService.create(toDoCreateRequest));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @Override
    @PutMapping("/update/{id}")
    public ResponseEntity<ToDoListDto> update(@PathVariable Long id, @RequestBody ToDoCreateRequestDto toDoUpdateRequest) {
        if(toDoUpdateRequest != null) {
            return ResponseEntity.ok(todoService.update(id,toDoUpdateRequest));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ToDoListDto> getById(@PathVariable Long id) {
        ToDoListDto toDoListDto = null;
        toDoListDto = todoService.getById(id);
        if(toDoListDto != null) {
            return ResponseEntity.ok(todoService.getById(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    @GetMapping
    public List<ToDoListDto> getAll() {
        return todoService.getAll();
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        todoService.delete(id);
    }

    @GetMapping("/deadline/{deadline}")
    public List<ToDoList> findAllByDeadline(@PathVariable LocalDate deadline) {
        return todoService.findAllByDeadline(deadline);
    }

    @GetMapping("/status/{status}")
    public List<ToDoList> findAllByStatus(@PathVariable Status status) {
        return todoService.findAllByStatus(status);
    }
}
