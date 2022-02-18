package com.example.coursework.repository.mapper;

import com.example.coursework.model.Nomination;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class NominationMapper implements RowMapper<Nomination> {
    @Override
    public Nomination mapRow(ResultSet rs, int rowNum) throws SQLException {
        Nomination nomination = new Nomination();
        nomination.setId(UUID.fromString(rs.getString("id")));
        nomination.setTournamentId(UUID.fromString(rs.getString("tournament_id")));
        nomination.setName(rs.getString("name"));

        return nomination;
    }
}
