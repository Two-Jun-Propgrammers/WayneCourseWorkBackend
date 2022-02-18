package com.example.coursework.service;

import com.example.coursework.model.Nomination;
import com.example.coursework.repository.NominationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NominationService {
    @Autowired
    private NominationRepository nominationRepository;

    public List<UUID> findAll() {
        return nominationRepository.findAll();
    }

    public Nomination search(UUID id) {
        return nominationRepository.search(id);
    }

    public boolean create(Nomination nomination) {
        return nominationRepository.create(nomination);
    }

    public boolean update(UUID id, Nomination nomination) {
        return nominationRepository.update(id, nomination);
    }

    public boolean delete(UUID id) {
        return nominationRepository.delete(id);
    }
}
