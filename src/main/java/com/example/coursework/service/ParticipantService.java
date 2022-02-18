package com.example.coursework.service;

import com.example.coursework.model.Participant;
import com.example.coursework.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ParticipantService {
    @Autowired
    private ParticipantRepository participantRepository;

    public List<UUID> findAll() {
        return participantRepository.findAll();
    }

    public Participant search(UUID id) {
        return participantRepository.search(id);
    }

    public boolean create(Participant participant) {
        return participantRepository.create(participant);
    }

    public boolean update(UUID id, Participant participant) {
        return participantRepository.update(id, participant);
    }

    public boolean delete(UUID id) {
        return participantRepository.delete(id);
    }
}
