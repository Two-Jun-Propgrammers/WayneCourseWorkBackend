package com.example.coursework.repository;

import com.example.coursework.model.Arena;
import com.example.coursework.repository.mapper.ArenaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ArenaRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    @Autowired
    private ArenaMapper arenaMapper;

    public List<UUID> findAll() {
        String sql = "SELECT * FROM arena.arena";
        List<Arena> arenas = template.query(sql, arenaMapper);
        List<UUID> result = new ArrayList<>();
        for (Arena arena : arenas) {
            result.add(arena.getId());
        }
        return result;
    }

    public Arena search(UUID id)
    {
        String sql = "SELECT * FROM arena.arena WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);
        return template.queryForObject(sql, params, arenaMapper);
    }

    public boolean create(Arena arena) {
        String sql = "INSERT INTO arena.arena (id, name, location_id) VALUES (:id, :name, :locationId)";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", UUID.randomUUID())
                .addValue("name", arena.getName())
                .addValue("locationId", arena.getLocationId());
        try {
            template.update(sql, params);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean check(UUID id) {
        return search(id) == null;
    }

    public boolean update(UUID id, Arena arena) {
        if (check(id)) {
            return false;
        }
        String sql = "UPDATE arena.arena SET name = :name, location_id = :locationId WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("name", arena.getName())
                .addValue("locationId", arena.getLocationId())
                .addValue("id", id);
        try {
            template.update(sql, params);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean delete(UUID id) {
        if (check(id)) {
            return false;
        }
        String sql = "DELETE FROM arena.arena WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);
        try{
            template.update(sql, params);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }
}
