package com.example.coursework.service;

import com.example.coursework.model.Judge;
import com.example.coursework.repository.JudgesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class JudgesService {
    @Autowired
    private JudgesRepository judgesRepository;

    public List<UUID> findAll() {
        return judgesRepository.findAll();
    }

    public Judge search(UUID id) {
        return judgesRepository.search(id);
    }

    public boolean create(Judge judge) {
        return judgesRepository.create(judge);
    }

    public boolean update(UUID id, Judge judge) {
        return judgesRepository.update(id, judge);
    }

    public boolean delete(UUID id) {
        return judgesRepository.delete(id);
    }
}
