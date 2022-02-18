package com.example.coursework.repository;

import com.example.coursework.model.TableRounds;
import com.example.coursework.repository.mapper.TableRoundsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TableRoundsRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    @Autowired
    private TableRoundsMapper tableRoundsMapper;

    public List<TableRounds> findAll()
    {
        String sql = "select t2.name, t3.name, t1.number, t1.name from rounds.rounds t1 inner join nomination.nomination t2 on t1.nomination_id = t2.id inner join weapon_category.weapon_category t3 on t1.weapon_id = t3.id";
        return template.query(sql, tableRoundsMapper);
    }
}
