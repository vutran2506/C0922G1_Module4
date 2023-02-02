package com.example.service;

import com.example.model.Settings;
import com.example.repository.ISettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SettingService implements ISettingService{
    @Autowired
    private ISettingRepository settingRepository;
    @Override
    public List<Settings> findAll() {
        return settingRepository.findAll();
    }

    @Override
    public void update(Settings setting) {
settingRepository.update(setting);
    }

    @Override
    public Settings findById(int id) {
        return settingRepository.findById(id);
    }
}
