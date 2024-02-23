package com.example.Group.Models.Repositories;

import com.example.Group.Interfaces.FormEducationRepository;
import com.example.Group.Models.FormEducation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcFormEducationRepository implements FormEducationRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcFormEducationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<FormEducation> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM \"Form_education\"",
                this::mapRowToFormEducation);
    }

    @Override
    public Optional<FormEducation> findById(Integer id) {

        List<FormEducation> results = jdbcTemplate.query(
                "SELECT * FROM \"Form_education\" WHERE id = 1\n",
                this::mapRowToFormEducation, id);

        return results.isEmpty() ?
                Optional.empty() :
                Optional.of(results.get(0));
    }

    @Override
    public FormEducation save(FormEducation group) {
        jdbcTemplate.update(
                "INSERT INTO \"Form_education\" (\"name_Form\") VALUES (?)",
                group.GetNameForm()
        );
        return group;
    }

    private FormEducation mapRowToFormEducation(ResultSet row, int rowNum) throws SQLException {
        return new FormEducation(
                row.getInt("id"),
                row.getDate("created_At"),
                row.getString("name_Form"));
    }
}
