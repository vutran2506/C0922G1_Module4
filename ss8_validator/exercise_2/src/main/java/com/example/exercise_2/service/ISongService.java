package com.example.exercise_2.service;

import com.example.exercise_2.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    void save(Song song);
    Song findById(int id);
    Page<Song> findByName(String name,Pageable pageable);
    Page<Song> findByNameAndSingerAndCategory(String nameSearch , String SingerSearch, String category,Pageable pageable);
}
