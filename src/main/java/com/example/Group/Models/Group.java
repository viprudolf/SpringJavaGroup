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
    private int id;

    private Date createdAt = new Date();
    private String _idSpeciality;
    private String _idQualification;
    private String _idFormEducation;
    private String _idFaculty;
    private String _idName;
    private String _idCourse;
    private String _idCountStudent;
    private String _idCountSubgroup;

    public Group(int a) {

    }

    @Override
    public String getId() {
        return String.valueOf(id);
    }
    public String GetIdSpeciality() {
        return _idSpeciality;
    }
    public String GetIdQualification() {
        return _idQualification;
    }
    public String GetIdFormEducation() {
        return _idFormEducation;
    }
    public String GetIdFaculty() {
        return _idFaculty;
    }
    public String GetIdName() {
        return _idName;
    }
    public String GetIdCourse() {
        return _idCourse;
    }
    public String GetIdCountStudent() {
        return _idCountStudent;
    }
    public String GetIdCountSubgroup() {
        return _idCountSubgroup;
    }

    @Override
    public boolean isNew() {
        return true;
    }
}



