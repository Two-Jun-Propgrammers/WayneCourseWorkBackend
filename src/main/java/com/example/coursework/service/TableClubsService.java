package com.example.coursework.service;

import com.example.coursework.model.TableClubs;
import com.example.coursework.repository.TableClubsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableClubsService {
    @Autowired
    private TableClubsRepository tableClubsRepository;

    public List<TableClubs> findAll() {
        return tableClubsRepository.findAll();
    }
}
