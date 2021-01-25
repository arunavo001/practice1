package com.upgrad.course;

import com.upgrad.course.dto.SongDto;
import com.upgrad.course.entity.SongEntity;
import com.upgrad.course.dao.SongDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;
import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringbootApplicationTest {

    @LocalServerPort
    int randomServerPort;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    private SongDao songDao;

    @BeforeEach
    void clean() {
        songDao.deleteAll();
    }

    @Test
    public void shouldReturn201WhenSong1IsCreatedSuccessfully() {
        SongDto songDto = new SongDto("song1", "movie1", "singer1");

        final String baseUrl = "http://localhost:" + randomServerPort + "/api/v1/admin";
        ResponseEntity<Long> response = testRestTemplate.postForEntity(baseUrl + "/songs/", songDto, Long.class);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertEquals(1, songDao.findAll().size());
        Optional<SongEntity> savedSong = songDao.findById(Objects.requireNonNull(response.getBody()));
        Assertions.assertTrue(savedSong.isPresent());
        Assertions.assertEquals("song1", savedSong.get().getName());
    }

}
