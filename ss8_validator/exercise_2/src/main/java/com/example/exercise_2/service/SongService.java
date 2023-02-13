package com.example.exercise_2.service;

import com.example.exercise_2.model.Song;
import com.example.exercise_2.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository songRepository;
    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public void save(Song song) {
songRepository.save(song);
    }

    @Override
    public Song findById(int id) {
        return songRepository.findById(id).get();
    }

    @Override
    public Page<Song> findByName(String name, Pageable pageable) {

        return songRepository.findByNameSongContaining(name, pageable);
    }

    @Override
    public Page<Song> findByNameAndSingerAndCategory(String nameSearch, String SingerSearch, String category, Pageable pageable) {
        return songRepository.findByNameSongContainingAndSingerContainingAndCategoryContaining(nameSearch, SingerSearch, category, pageable);
    }
}
