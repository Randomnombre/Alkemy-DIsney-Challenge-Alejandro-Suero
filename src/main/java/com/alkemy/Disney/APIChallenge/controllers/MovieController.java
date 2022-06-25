package com.alkemy.Disney.APIChallenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.Disney.APIChallenge.dto.MovieDTO;
import com.alkemy.Disney.APIChallenge.service.MovieService;

@RestController
@RequestMapping("movies")
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@PostMapping
	public ResponseEntity<MovieDTO> save(@RequestBody MovieDTO movieDto) {
		
		MovieDTO movieSaved = movieService.save(movieDto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(movieSaved);
	}
	
	@RequestMapping
	public ResponseEntity<List<MovieDTO>> getAll() {
		
		List<MovieDTO> movies = movieService.getAllMovies();
		
		return ResponseEntity.ok().body(movies);
	}
}
