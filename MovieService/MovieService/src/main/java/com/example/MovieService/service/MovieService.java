package com.example.MovieService.service;

import com.example.MovieService.model.Movie;
import com.example.MovieService.repository.MovieRepository;
import com.example.MovieService.util.InvalidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMoviesService() {
        return movieRepository.findAll();
    }

    public List<Movie> getMovieByGenreId(Long genreId) throws InvalidException {

        List<Movie> movies = movieRepository.findByGenreId(genreId);

        if(movies.isEmpty()) {
            throw  new InvalidException("Can not file genre with id = " + genreId);
        }

        return movies;
    }
}
