package com.example.coursework.service;

import com.example.coursework.model.Tournament;
import com.example.coursework.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TournamentService {
    @Autowired
    private TournamentRepository tournamentRepository;

    public List<UUID> findAll() {
        return tournamentRepository.findAll();
    }

    public Tournament search(UUID id) {
        return tournamentRepository.search(id);
    }

    public boolean create(Tournament tournament) {
        return tournamentRepository.create(tournament);
    }

    public boolean update(UUID id, Tournament tournament) {
        return tournamentRepository.update(id, tournament);
    }

    public boolean delete(UUID id) {
        return tournamentRepository.delete(id);
    }
}
