package com.upgrad.course.dao;

import com.upgrad.course.entity.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongDao extends JpaRepository<SongEntity, Long> {
}
