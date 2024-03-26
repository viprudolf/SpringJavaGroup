package com.example.Group.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("/faculty")
public class Faculties {
    @Id
    private long id;
    @Size(min = 1, message = "Поле не может быть пустым!")
    private String name;
    @Size(min = 1, message = "Поле не может быть пустым!")
    private String abbr;
    @Size(min = 1, message = "Поле не может быть пустым!")
    private String dean;
    @Size(min = 1, message = "Поле не может быть пустым!")
    private String phone;

    public Faculties(String name, String abbr, String dean, String phone) {
        this.name = name;
        this.abbr = abbr;
        this.dean = dean;
        this.phone = phone;
    }
}
