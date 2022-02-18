package com.example.coursework.repository;

import com.example.coursework.model.TableDuels;
import com.example.coursework.repository.mapper.TableDuelsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TableDuelsRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    @Autowired
    private TableDuelsMapper tableDuelsMapper;

    public List<TableDuels> findAll()
    {
        String sql = "select t1.number, t2.lastname, t3.name, t5.lastname, t4.points, t7.lastname, t6.points from duel.duel t1 inner join judges.judges t2 on t1.judges_id = t2.id inner join platform.platform t3 on t1.platform_id = t3.id inner join duel_results.duel_results t4 on t1.id = t4.duel_id inner join participants.participants t5 on t4.participant_id = t5.id inner join duel_results.duel_results t6 on t1.id = t6.duel_id and t4.id !=t6.id inner join participants.participants t7 on t6.participant_id = t7.id";
        return template.query(sql, tableDuelsMapper);
    }
}
