package com.example.coursework.service;

import com.example.coursework.model.UserRoles;
import com.example.coursework.repository.UsersRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsersRolesService {
    @Autowired
    private UsersRolesRepository usersRolesRepository;

    public List<UUID> findAll() {
        return usersRolesRepository.findAll();
    }

    public UserRoles search(UUID id) {
        return usersRolesRepository.search(id);
    }

    public boolean create(UserRoles userRoles) {
        return usersRolesRepository.create(userRoles);
    }

    public boolean update(UUID id, UserRoles userRoles) {
        return usersRolesRepository.update(id, userRoles);
    }

    public boolean delete(UUID id) {
        return usersRolesRepository.delete(id);
    }
}
