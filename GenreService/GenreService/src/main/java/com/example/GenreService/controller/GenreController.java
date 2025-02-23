package com.example.GenreService.controller;

import com.example.GenreService.model.Genre;
import com.example.GenreService.service.GenreService;
import com.example.GenreService.util.InvalidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping()
    public List<Genre> getAllMovies() {
        List<Genre> genres = genreService.getAllGenresService();
        return genres;
    }

    @GetMapping("/{genreId}")
    public Genre getGenresByGenreId(@PathVariable long genreId) throws InvalidException {
        Optional<Genre> genre = genreService.getGenreById(genreId);
        return genre.get();
    }
}
