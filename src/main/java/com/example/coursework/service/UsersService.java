package com.example.coursework.service;

import com.example.coursework.model.User;
import com.example.coursework.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public List<UUID> findAll() {
        return usersRepository.findAll();
    }

    public User search(UUID id) {
        return usersRepository.search(id);
    }

    public boolean create(User user) {
        return usersRepository.create(user);
    }

    public boolean update(UUID id, User user) {
        return usersRepository.update(id, user);
    }

    public boolean delete(UUID id) {
        return usersRepository.delete(id);
    }
}
