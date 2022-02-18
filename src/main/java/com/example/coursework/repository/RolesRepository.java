package com.example.coursework.repository;

import com.example.coursework.model.Role;
import com.example.coursework.repository.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class RolesRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    @Autowired
    private RoleMapper roleMapper;

    public List<UUID> findAll() {
        String sql = "SELECT * FROM roles.roles";
        List<Role> roles = template.query(sql, roleMapper);
        List<UUID> result = new ArrayList<>();
        for (Role role : roles) {
            result.add(role.getId());
        }
        return result;
    }

    public Role search(UUID id)
    {
        String sql = "SELECT * FROM roles.roles WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);
        return template.queryForObject(sql, params, roleMapper);
    }

    public boolean create(Role role) {
        String sql = "INSERT INTO roles.roles (id, name) VALUES (:id, :name)";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", UUID.randomUUID())
                .addValue("name", role.getName());
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

    public boolean update(UUID id, Role role) {
        if (check(id)) {
            return false;
        }
        String sql = "UPDATE roles.roles SET name = :name WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("name", role.getName())
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
        String sql = "DELETE FROM roles.roles WHERE id = :id";
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
