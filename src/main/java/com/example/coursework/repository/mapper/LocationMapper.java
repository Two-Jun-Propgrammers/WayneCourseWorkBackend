package com.example.coursework.repository.mapper;

import com.example.coursework.model.Location;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class LocationMapper implements RowMapper<Location>{
    @Override
    public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
        Location location = new Location();
        location.setId(UUID.fromString(rs.getString("id")));
        location.setCity(rs.getString("city"));
        location.setStreet(rs.getString("street"));
        location.setHouse(rs.getString("house"));

        return location;
    }
}
