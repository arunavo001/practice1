package com.upgrad.course.service;

import com.upgrad.course.entity.SongEntity;
import com.upgrad.course.dao.SongDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    SongDao songDao;

    @Transactional
    public Long addSong(SongEntity songEntity) {

        SongEntity saved = songDao.save(songEntity);
        return saved.getId();
    }
}
