package com.example.coursework.repository.mapper;

import com.example.coursework.model.TableArenas;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TableArenasMapper implements RowMapper<TableArenas> {
    @Override
    public TableArenas mapRow(ResultSet rs, int rowNum) throws SQLException {
        TableArenas tableArenas = new TableArenas();
        tableArenas.setName(rs.getString(1));
        tableArenas.setCity(rs.getString(2));
        tableArenas.setStreet(rs.getString(3));
        tableArenas.setHouse(rs.getString(4));

        return tableArenas;
    }
}
