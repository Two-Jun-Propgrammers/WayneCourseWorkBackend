package com.example.coursework.repository.mapper;

import com.example.coursework.model.TableClubs;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TableClubsMapper implements RowMapper<TableClubs> {
    @Override
    public TableClubs mapRow(ResultSet rs, int rowNum) throws SQLException {
        TableClubs tableClubs = new TableClubs();
        tableClubs.setName(rs.getString(1));
        tableClubs.setActivity(rs.getBoolean(2));
        tableClubs.setCity(rs.getString(3));
        tableClubs.setStreet(rs.getString(4));
        tableClubs.setHouse(rs.getString(5));

        return tableClubs;
    }
}
