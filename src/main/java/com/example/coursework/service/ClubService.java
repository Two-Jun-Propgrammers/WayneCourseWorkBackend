package com.example.coursework.service;

import com.example.coursework.model.Club;
import com.example.coursework.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClubService {
    @Autowired
    private ClubRepository clubRepository;

    public List<UUID> findAll() {
        return clubRepository.findAll();
    }

    public Club search(UUID id) {
        return clubRepository.search(id);
    }

    public boolean create(Club club) {
        return clubRepository.create(club);
    }

    public boolean update(UUID id, Club club) {
        return clubRepository.update(id, club);
    }

    public boolean changeActive(UUID id) {
        return clubRepository.delete(id);
    }
}
