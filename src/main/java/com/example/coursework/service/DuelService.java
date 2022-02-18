package com.example.coursework.service;

import com.example.coursework.model.Duel;
import com.example.coursework.repository.DuelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DuelService {
    @Autowired
    private DuelRepository duelRepository;

    public List<UUID> findAll() {
        return duelRepository.findAll();
    }

    public Duel search(UUID id) {
        return duelRepository.search(id);
    }

    public boolean create(Duel duel) {
        return duelRepository.create(duel);
    }

    public boolean update(UUID id, Duel duel) {
        return duelRepository.update(id, duel);
    }

    public boolean delete(UUID id) {
        return duelRepository.delete(id);
    }
}
