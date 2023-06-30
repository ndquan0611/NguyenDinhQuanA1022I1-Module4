package com.appmusic.repository;

import com.appmusic.model.Music;

import java.util.List;

public interface IMusicRepository {
    List<Music> findAll();

    void save(Music music);

    void update(int id, Music music);

    void delete(int id);

    Music findById(int id);
}
