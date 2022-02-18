package com.example.coursework.repository.mapper;

import com.example.coursework.model.TableRounds;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TableRoundsMapper implements RowMapper<TableRounds> {
    @Override
    public TableRounds mapRow(ResultSet rs, int rowNum) throws SQLException {
        TableRounds tableRounds = new TableRounds();
        tableRounds.setNomination(rs.getString(1));
        tableRounds.setWeapon(rs.getString(2));
        tableRounds.setRoundNumber(rs.getInt(3));
        tableRounds.setRoundName(rs.getString(4));

        return tableRounds;
    }
}
