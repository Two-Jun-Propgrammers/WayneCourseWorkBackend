package com.example.coursework.repository.mapper;

import com.example.coursework.model.Platform;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class PlatformMapper implements RowMapper<Platform> {
    @Override
    public Platform mapRow(ResultSet rs, int rowNum) throws SQLException {
        Platform platform = new Platform();
        platform.setId(UUID.fromString(rs.getString("id")));
        platform.setNumber(rs.getInt("number"));
        platform.setName(rs.getString("name"));

        return platform;
    }
}
