package com.example.coursework.repository.mapper;

import com.example.coursework.model.TableTournaments;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TableTournamentsMapper implements RowMapper<TableTournaments> {
    @Override
    public TableTournaments mapRow(ResultSet rs, int rowNum) throws SQLException {
        TableTournaments tableTournaments = new TableTournaments();
        tableTournaments.setName(rs.getString(1));
        tableTournaments.setArena(rs.getString(2));
        tableTournaments.setBeginning(rs.getDate(3));
        tableTournaments.setEnding(rs.getDate(4));

        return tableTournaments;
    }
}
