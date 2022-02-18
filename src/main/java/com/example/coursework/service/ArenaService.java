package com.example.coursework.service;

import com.example.coursework.model.Arena;
import com.example.coursework.repository.ArenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ArenaService {
    @Autowired
    private ArenaRepository arenaRepository;

    public List<UUID> findAll() {
        return arenaRepository.findAll();
    }

    public Arena search(UUID id) {
        return arenaRepository.search(id);
    }

    public boolean create(Arena arena) {
        return arenaRepository.create(arena);
    }

    public boolean update(UUID id, Arena arena) {
        return arenaRepository.update(id, arena);
    }

    public boolean delete(UUID id) {
        return arenaRepository.delete(id);
    }
}
