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
public class Speciality implements Persistable<String> {
    @Id
    private Long id;
    private Date createdAt = new Date();

    private String _nameSpeciality;
    private String _profile;

    @Override
    public boolean isNew() {
        return true;
    }
}
