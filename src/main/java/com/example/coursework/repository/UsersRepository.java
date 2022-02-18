package com.example.coursework.repository;

import com.example.coursework.model.User;
import com.example.coursework.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class UsersRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    @Autowired
    private UserMapper userMapper;

    public List<UUID> findAll() {
        String sql = "SELECT * FROM users.users";
        List<User> users = template.query(sql, userMapper);
        List<UUID> result = new ArrayList<>();
        for (User user : users) {
            result.add(user.getId());
        }
        return result;
    }

    public User search(UUID id)
    {
        String sql = "SELECT * FROM users.users WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);
        return template.queryForObject(sql, params, userMapper);
    }

    public boolean create(User user) {
        String sql = "INSERT INTO users.users (id, username, password, firstname, lastname)  VALUES (:id, :username, :password, :firstName, :lastName)";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", UUID.randomUUID())
                .addValue("username", user.getUsername())
                .addValue("password", user.getPassword())
                .addValue("firstName", user.getFirstName())
                .addValue("lastName", user.getLastName());
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

    public boolean update(UUID id, User user) {
        if (check(id)) {
            return false;
        }
        String sql = "UPDATE users.users SET username = :username, password = :password, firstname = :firstName, lastname = :lastName WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("username", user.getUsername())
                .addValue("password", user.getPassword())
                .addValue("firstName", user.getFirstName())
                .addValue("lastName", user.getLastName())
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
        String sql = "DELETE FROM users.users WHERE id = :id";
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
