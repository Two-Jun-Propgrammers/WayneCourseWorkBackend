package com.example.coursework.repository.mapper;

import com.example.coursework.model.Arena;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class ArenaMapper implements RowMapper<Arena> {
    @Override
    public Arena mapRow(ResultSet rs, int rowNum) throws SQLException{
        Arena arena = new Arena();
        arena.setId(UUID.fromString(rs.getString("id")));
        arena.setName(rs.getString("name"));
        arena.setLocationId(UUID.fromString(rs.getString("location_id")));

        return arena;
    }
}
