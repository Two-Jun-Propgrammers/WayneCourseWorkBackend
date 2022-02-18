package com.example.coursework.repository.mapper;

import com.example.coursework.model.Club;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class ClubMapper implements RowMapper<Club> {
    @Override
    public Club mapRow(ResultSet rs, int rowNum) throws SQLException {
        Club club = new Club();
        club.setId(UUID.fromString(rs.getString("id")));
        club.setName(rs.getString("name"));
        club.setActivity(rs.getBoolean("activity"));
        club.setLocationId(UUID.fromString(rs.getString("location_id")));

        return club;
    }
}
