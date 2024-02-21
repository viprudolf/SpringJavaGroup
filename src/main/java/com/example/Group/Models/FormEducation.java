package com.example.Group.Models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Data
@Table
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force=true)
public class FormEducation implements Persistable<String> {
    @Id
    private int id;

    private Date createdAt = new Date();
    private  String _nameForm;

    public String GetNameForm() {
        return _nameForm;
    }

    @Override
    public String getId() {
        return String.valueOf(id);
    }

    @Override
    public boolean isNew() {
        return true;
    }
}
