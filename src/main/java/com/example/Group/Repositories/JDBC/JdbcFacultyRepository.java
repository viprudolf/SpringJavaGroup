package com.example.Group.Repositories.JDBC;

import com.example.Group.Models.Faculties;
import com.example.Group.Repositories.FacultiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcFacultyRepository implements FacultiesRepository {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public JdbcFacultyRepository(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public Iterable<Faculties> findAll() {
        return jdbcTemplate.query("select * from faculties", this::mapRow);
    }

    @Override
    public Optional<Faculties> findById(long id){
        List<Faculties> result = jdbcTemplate.query("select * from faculties where id = ?", this::mapRow, id);
        return result.isEmpty() ? Optional.empty() : Optional.of(result.get(0));
    }

    private Faculties mapRow(ResultSet row, int rowNum) throws SQLException {
        return new Faculties(row.getLong("id"), row.getString("name"),
                row.getString("abbr"), row.getString("dean"), row.getString("phone"));
    }

    @Override
    public Faculties saveFaculty(Faculties faculties) {
        jdbcTemplate.update("insert into faculties (name, abbr, dean, phone) values (?, ?, ?,?)",
                faculties.getName(),
                faculties.getAbbr(),
                faculties.getDean(),
                faculties.getPhone());
        return faculties;
    }

    @Override
    public void deleteFaculty(long id){
        jdbcTemplate.update("delete from faculties where id=?", id);
    }

    @Override
    public Faculties updateFaculty(Faculties faculties){
        jdbcTemplate.update("update faculties set name=?,abbr=?,dean=?,phone=?  where id=?",
                faculties.getName(), faculties.getAbbr(), faculties.getDean(), faculties.getPhone(), faculties.getId());
        return faculties;
    }
}
