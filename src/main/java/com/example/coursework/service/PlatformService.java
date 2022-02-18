package com.example.coursework.service;

import com.example.coursework.model.Platform;
import com.example.coursework.repository.PlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PlatformService {
    @Autowired
    private PlatformRepository platformRepository;

    public List<UUID> findAll() {
        return platformRepository.findAll();
    }

    public Platform search(UUID id) {
        return platformRepository.search(id);
    }

    public boolean create(Platform platform) {
        return platformRepository.create(platform);
    }

    public boolean update(UUID id, Platform platform) {
        return platformRepository.update(id, platform);
    }

    public boolean delete(UUID id) {
        return platformRepository.delete(id);
    }
}
