package com.example.coursework.service;

import com.example.coursework.model.TableTournaments;
import com.example.coursework.repository.TableTournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableTournamentService {
    @Autowired
    private TableTournamentRepository tableTournamentRepository;

    public List<TableTournaments> findAll() {
        return tableTournamentRepository.findAll();
    }
}
