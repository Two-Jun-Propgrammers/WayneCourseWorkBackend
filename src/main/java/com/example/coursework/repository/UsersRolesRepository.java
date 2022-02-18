package com.example.coursework.repository;

import com.example.coursework.model.UserRoles;
import com.example.coursework.repository.mapper.UserRolesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class UsersRolesRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    @Autowired
    private UserRolesMapper userRolesMapper;

    public List<UUID> findAll() {
        String sql = "SELECT * FROM users_roles.users_roles";
        List<UserRoles> userRoles = template.query(sql, userRolesMapper);
        List<UUID> result = new ArrayList<>();
        for (UserRoles userRole : userRoles) {
            result.add(userRole.getId());
        }
        return result;
    }

    public UserRoles search(UUID id)
    {
        String sql = "SELECT * FROM users_roles.users_roles WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);
        return template.queryForObject(sql, params, userRolesMapper);
    }

    public boolean create(UserRoles userRoles) {
        String sql = "INSERT INTO users_roles.users_roles (id, user_id, role_id) VALUES (:id, :userId, :roleId)";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", UUID.randomUUID())
                .addValue("userId", userRoles.getUserId())
                .addValue("roleId", userRoles.getRoleId());
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

    public boolean update(UUID id, UserRoles userRoles) {
        if (check(id)) {
            return false;
        }
        String sql = "UPDATE users_roles.users_roles SET user_id = :userId, role_id = :roleId WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("userId", userRoles.getUserId())
                .addValue("roleId", userRoles.getRoleId())
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
        String sql = "DELETE FROM users_roles.users_roles WHERE id = :id";
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
