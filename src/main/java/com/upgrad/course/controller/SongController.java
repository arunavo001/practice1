package com.upgrad.course.controller;

import com.upgrad.course.dto.SongDto;
import com.upgrad.course.entity.SongEntity;
import com.upgrad.course.service.SongService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/admin/")
public class SongController {

    @Autowired
    SongService songService;

    @Autowired
    ModelMapper modelMapper;

    // TODO: Define API Endpoint for adding a new song
	//  The endpoint should be exposed as "/songs"
    //  Use appropriate annotation to receive the request body as a method argument
    @PostMapping(value = "/songs")
    public ResponseEntity<SongDto> addSong(@RequestBody SongDto songDto) {
        // TODO: Use ModelMapper's map() method to map the DTO with the Entity
        //  Call service method to add a new song
        //  Return 201 CREATED response with saved song id as body
        SongEntity newSong=modelMapper.map(songDto,SongEntity.class);
        Long savedSong=songService.addSong(newSong);
        SongDto savedMovieDTO=modelMapper.map(savedSong,SongDto.class);
        return new ResponseEntity<>(savedMovieDTO,HttpStatus.CREATED);
    }
}
