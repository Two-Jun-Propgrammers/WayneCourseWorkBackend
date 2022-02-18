package com.example.coursework.repository.mapper;

import com.example.coursework.model.Judge;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class JudgesMapper implements RowMapper<Judge> {
    @Override
    public Judge mapRow(ResultSet rs, int rowNum) throws SQLException {
        Judge judge = new Judge();
        judge.setId(UUID.fromString(rs.getString("id")));
        judge.setFirstName(rs.getString("firstname"));
        judge.setLastName(rs.getString("lastname"));

        return judge;
    }
}
