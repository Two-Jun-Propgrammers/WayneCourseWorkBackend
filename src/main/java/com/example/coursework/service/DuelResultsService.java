package com.example.coursework.service;

import com.example.coursework.model.DuelResults;
import com.example.coursework.repository.DuelResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DuelResultsService {
    @Autowired
    private DuelResultsRepository duelResultsRepository;

    public List<UUID> findAll() {
        return duelResultsRepository.findAll();
    }

    public DuelResults search(UUID id) {
        return duelResultsRepository.search(id);
    }

    public boolean create(DuelResults duelResults) {
        return duelResultsRepository.create(duelResults);
    }

    public boolean update(UUID id, DuelResults duelResults) {
        return duelResultsRepository.update(id, duelResults);
    }

    public boolean delete(UUID id) {
        return duelResultsRepository.delete(id);
    }
}
