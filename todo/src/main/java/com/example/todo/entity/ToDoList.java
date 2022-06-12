package com.example.todo.entity;

import com.example.todo.enums.Status;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@RequiredArgsConstructor
@ToString
@Entity
public class ToDoList extends AbstractEntity{

    private String name;
    private LocalDateTime createdAt;
    private LocalDate deadline;
    @Enumerated(EnumType.STRING)
    private Status statusTask;

}
