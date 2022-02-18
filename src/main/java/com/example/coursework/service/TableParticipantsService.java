package com.example.coursework.service;

import com.example.coursework.model.TableParticipants;
import com.example.coursework.repository.TableParticipantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableParticipantsService {
    @Autowired
    private TableParticipantsRepository tableParticipantsRepository;

    public List<TableParticipants> findAll() {
        return tableParticipantsRepository.findAll();
    }
}
