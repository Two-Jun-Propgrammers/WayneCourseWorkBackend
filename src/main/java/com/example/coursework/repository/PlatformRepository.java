package com.example.coursework.repository;

import com.example.coursework.model.Platform;
import com.example.coursework.repository.mapper.PlatformMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class PlatformRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    @Autowired
    private PlatformMapper platformMapper;

    public List<UUID> findAll() {
        String sql = "SELECT * FROM platform.platform";
        List<Platform> platforms = template.query(sql, platformMapper);
        List<UUID> result = new ArrayList<>();
        for (Platform platform : platforms) {
            result.add(platform.getId());
        }
        return result;
    }

    public Platform search(UUID id)
    {
        String sql = "SELECT * FROM platform.platform WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);
        return template.queryForObject(sql, params, platformMapper);
    }

    public boolean create(Platform platform) {
        String sql = "INSERT INTO platform.platform (id, number, name) VALUES (:id, :number, :name)";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", UUID.randomUUID())
                .addValue("number", platform.getNumber())
                .addValue("name", platform.getName());
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

    public boolean update(UUID id, Platform platform) {
        if (check(id)) {
            return false;
        }
        String sql = "UPDATE platform.platform SET number = :number, name = :name WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("number", platform.getNumber())
                .addValue("name", platform.getName())
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
        String sql = "DELETE FROM platform.platform WHERE id = :id";
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
