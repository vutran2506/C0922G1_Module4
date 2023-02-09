package com.example.exercise_2.service;

import com.example.exercise_2.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    void save(Song song);
    Song findById(int id);
}
