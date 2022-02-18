package com.example.coursework.repository.mapper;

import com.example.coursework.model.Tournament;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class TournamentMapper implements RowMapper<Tournament> {
    @Override
    public Tournament mapRow(ResultSet rs, int rowNum) throws SQLException {
        Tournament tournament = new Tournament();
        tournament.setId(UUID.fromString(rs.getString("id")));
        tournament.setName(rs.getString("name"));
        tournament.setBeginning(rs.getDate("beginning"));
        tournament.setEnding(rs.getDate("ending"));
        tournament.setArenaId(UUID.fromString(rs.getString("arena_id")));

        return tournament;
    }
}
