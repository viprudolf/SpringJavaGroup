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
                "SELECT * FROM \"Group\"",
                this::mapRowToGroup);
    }

    @Override
    public Optional<Group> findById(Integer id) {

        List<Group> results = jdbcTemplate.query(
                "SELECT * FROM \"Group\" WHERE id = 1\n",
                this::mapRowToGroup, id);

        return results.isEmpty() ?
                Optional.empty() :
                Optional.of(results.get(0));
    }

    @Override
    public Group save(Group group) {
        jdbcTemplate.update(
                "INSERT INTO \"Group\" (\"_idSpeciality\", \"_idQualification\", \"_idFormEducation\", \"_idFaculty\", \"_idName\", \"_idCourse\", \"_idCountStudent\", \"_idCountSubgroup\")" +
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
                row.getDate("createdAt"),
                row.getString("_idSpeciality"),
                row.getString("_idQualification"),
                row.getString("_idFormEducation"),
                row.getString("_idFaculty"),
                row.getString("_idName"),
                row.getString("_idCourse"),
                row.getString("_idCountStudent"),
                row.getString("_idCountSubgroup"));
    }
}

