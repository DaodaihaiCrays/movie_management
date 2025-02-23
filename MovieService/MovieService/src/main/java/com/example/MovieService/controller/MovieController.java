package com.example.MovieService.controller;

import com.example.MovieService.model.Movie;
import com.example.MovieService.service.MovieService;
import com.example.MovieService.util.InvalidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping()
    public List<Movie> getAllMovies() {
        List<Movie> movies = movieService.getAllMoviesService();
        return movies;
    }

    @GetMapping("/{genreId}")
    public List<Movie> getMoviesByGenreId(@PathVariable long genreId) throws InvalidException {
        List<Movie> movies = movieService.getMovieByGenreId(genreId);
        return movies;
    }
}
