package com.appmusic.service;

import com.appmusic.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();

    void save(Music music);

    void update(int id, Music music);

    void delete(int id);

    Music findById(int id);
}
