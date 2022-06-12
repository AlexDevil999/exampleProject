package com.example.todo.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ToDoCreateRequestDto {

    private String name;
    private LocalDate deadline;
}
