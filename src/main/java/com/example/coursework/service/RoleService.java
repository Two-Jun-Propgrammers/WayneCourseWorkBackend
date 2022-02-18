package com.example.coursework.service;

import com.example.coursework.model.Role;
import com.example.coursework.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoleService {
    @Autowired
    private RolesRepository rolesRepository;

    public List<UUID> findAll() {
        return rolesRepository.findAll();
    }

    public Role search(UUID id) {
        return rolesRepository.search(id);
    }

    public boolean create(Role role) {
        return rolesRepository.create(role);
    }

    public boolean update(UUID id, Role role) {
        return rolesRepository.update(id, role);
    }

    public boolean delete(UUID id) {
        return rolesRepository.delete(id);
    }
}
