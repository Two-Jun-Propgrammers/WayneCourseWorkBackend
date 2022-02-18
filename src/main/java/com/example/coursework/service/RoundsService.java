package com.example.coursework.service;

import com.example.coursework.model.Round;
import com.example.coursework.repository.RoundsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoundsService {
    @Autowired
    private RoundsRepository roundsRepository;

    public List<UUID> findAll() {
        return roundsRepository.findAll();
    }

    public Round search(UUID id) {
        return roundsRepository.search(id);
    }

    public boolean create(Round round) {
        return roundsRepository.create(round);
    }

    public boolean update(UUID id, Round round) {
        return roundsRepository.update(id, round);
    }

    public boolean delete(UUID id) {
        return roundsRepository.delete(id);
    }
}
