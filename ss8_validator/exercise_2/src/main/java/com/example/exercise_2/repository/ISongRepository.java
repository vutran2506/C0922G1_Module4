package com.example.exercise_2.repository;

import com.example.exercise_2.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song , Integer> {
    Page<Song> findByNameSongContaining(String name, Pageable pageable);
    Page<Song> findByNameSongContainingAndSingerContainingAndCategoryContaining(String name, String singer,String category,Pageable pageable);
}
