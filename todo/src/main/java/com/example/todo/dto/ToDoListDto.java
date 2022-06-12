package com.example.todo.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ToDoListDto {

    private Long id;
    private String name;
    private LocalDate deadline;
    private String task;
}
