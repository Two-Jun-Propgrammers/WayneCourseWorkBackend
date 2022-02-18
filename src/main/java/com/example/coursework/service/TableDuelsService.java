package com.example.coursework.service;

import com.example.coursework.model.TableDuels;
import com.example.coursework.repository.TableDuelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableDuelsService {
    @Autowired
    private TableDuelsRepository tableDuelsRepository;

    public List<TableDuels> findAll() {
        return tableDuelsRepository.findAll();
    }
}
