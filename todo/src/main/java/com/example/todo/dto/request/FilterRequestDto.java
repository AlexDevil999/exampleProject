package com.example.todo.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FilterRequestDto {
    private LocalDate localDate;
    private String status;
}
