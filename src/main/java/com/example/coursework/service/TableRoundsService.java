package com.example.coursework.service;

import com.example.coursework.model.TableRounds;
import com.example.coursework.repository.TableRoundsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableRoundsService {
    @Autowired
    private TableRoundsRepository tableRoundsRepository;

    public List<TableRounds> findAll() {
        return tableRoundsRepository.findAll();
    }
}
