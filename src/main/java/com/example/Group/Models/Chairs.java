package com.example.Group.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("/chair")
public class Chairs  {
    @Id
    private long id;
    @Min(value = 1, message = "Выберите факультет!")
    private long faculty_id;
    @Size(min = 1, message = "Поле не может быть пустым!")
    private String name;
    @Size(min = 1, message = "Поле не может быть пустым!")
    private String abbr;
    @Size(min = 1, message = "Поле не может быть пустым!")
    private String chief;
    @Size(min = 1, message = "Поле не может быть пустым!")
    private String phone;
    @NotNull
    private Faculties faculties;

    public Chairs(long faculty_id, String name, String abbr, String chief, String phone, Faculties faculties) {
        this.faculty_id = faculty_id;
        this.name = name;
        this.abbr = abbr;
        this.chief = chief;
        this.phone = phone;
        this.faculties = faculties;
    }
}