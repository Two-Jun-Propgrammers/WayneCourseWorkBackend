package com.example.coursework.repository.mapper;

import com.example.coursework.model.TableDuels;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TableDuelsMapper implements RowMapper<TableDuels> {
    @Override
    public TableDuels mapRow(ResultSet rs, int rowNum) throws SQLException {
        TableDuels tableDuels = new TableDuels();
        tableDuels.setDuelNumber(rs.getInt(1));
        tableDuels.setJudge(rs.getString(2));
        tableDuels.setPlatform(rs.getString(3));
        tableDuels.setParticipant1(rs.getString(4));
        tableDuels.setPoints1(rs.getInt(5));
        tableDuels.setParticipant2(rs.getString(6));
        tableDuels.setPoints2(rs.getInt(7));

        return tableDuels;
    }
}
