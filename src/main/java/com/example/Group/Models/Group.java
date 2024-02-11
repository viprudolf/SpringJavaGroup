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
public class Group implements Persistable<String> {
    @Id
    private Long id;
    private Date createdAt = new Date();

    private String _idSpeciality;
    private String _idQualification;
    private String _idFormEducation;
    private String _idFaculty;
    private String _idName;
    private String _idCourse;
    private String _idCountStudent;
    private String _idCountSubgroup;

    @Override
    public boolean isNew() {
        return true;
    }
}



