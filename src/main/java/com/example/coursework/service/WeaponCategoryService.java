package com.example.coursework.service;

import com.example.coursework.model.WeaponCategory;
import com.example.coursework.repository.WeaponCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WeaponCategoryService {
    @Autowired
    private WeaponCategoryRepository weaponCategoryRepository;

    public List<UUID> findAll() {
        return weaponCategoryRepository.findAll();
    }

    public WeaponCategory search(UUID id) {
        return weaponCategoryRepository.search(id);
    }

    public boolean create(WeaponCategory weaponCategory) {
        return weaponCategoryRepository.create(weaponCategory);
    }

    public boolean update(UUID id, WeaponCategory weaponCategory) {
        return weaponCategoryRepository.update(id, weaponCategory);
    }

    public boolean delete(UUID id) {
        return weaponCategoryRepository.delete(id);
    }
}
