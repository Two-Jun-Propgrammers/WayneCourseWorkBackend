package com.example.coursework.repository;

import com.example.coursework.model.TableArenas;
import com.example.coursework.repository.mapper.TableArenasMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TableArenasRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    @Autowired
    private TableArenasMapper tableArenasMapper;

    public List<TableArenas> findAll()
    {
        String sql = "select t1.name, t2.city, t2.street, t2.house from arena.arena t1 inner join location.location t2 on t1.location_id = t2.id";
        return template.query(sql, tableArenasMapper);
    }
}
