package com.example.Group.Models.Repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.example.Group.Interfaces.GroupRepository;
import com.example.Group.Models.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcGroupRepository implements GroupRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcGroupRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Group> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM \"GGroup\"",
                this::mapRowToGroup);
    }

    @Override
    public Optional<Group> findById(Integer id) {

        List<Group> results = jdbcTemplate.query(
                "SELECT * FROM \"GGroup\" WHERE id = 1\n",
                this::mapRowToGroup, id);

        return results.isEmpty() ?
                Optional.empty() :
                Optional.of(results.get(0));
    }

    @Override
    public Group save(Group group) {
        jdbcTemplate.update(
                "INSERT INTO \"GGroup\" (\"id_Speciality\", \"id_Qualification\", \"id_FormEducation\", \"id_Faculty\", \"id_Name\", \"id_Course\", \"id_CountStudent\", \"id_CountSubgroup\")" +
                        " VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                group.GetIdSpeciality(),
                group.GetIdQualification(),
                group.GetIdFormEducation(),
                group.GetIdFaculty(),
                group.GetIdName(),
                group.GetIdCourse(),
                group.GetIdCountStudent(),
                group.GetIdCountSubgroup()
                );
        return group;
    }

    private Group mapRowToGroup(ResultSet row, int rowNum) throws SQLException {
        return new Group(
                row.getInt("id"),
                row.getDate("created_At"),
                row.getString("id_Speciality"),
                row.getString("id_Qualification"),
                row.getString("id_FormEducation"),
                row.getString("id_Faculty"),
                row.getString("id_Name"),
                row.getString("id_Course"),
                row.getString("id_CountStudent"),
                row.getString("id_CountSubgroup"));
    }
}

