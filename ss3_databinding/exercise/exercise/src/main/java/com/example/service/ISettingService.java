package com.example.service;

import com.example.model.Settings;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ISettingService {
    List<Settings> findAll();
    void update(Settings setting);
    Settings findById(int id);
}
