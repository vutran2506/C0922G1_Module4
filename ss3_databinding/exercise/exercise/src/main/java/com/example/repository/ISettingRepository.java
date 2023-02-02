package com.example.repository;

import com.example.model.Settings;

import java.util.List;

public interface ISettingRepository {
    List<Settings> findAll();
    void update(Settings setting);
    Settings findById(int id);

}
