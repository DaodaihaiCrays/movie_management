package com.example.GenreService.service;

import com.example.GenreService.model.Genre;
import com.example.GenreService.model.Movie;
import com.example.GenreService.repository.GenreRepository;
import com.example.GenreService.util.InvalidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public List<Genre> getAllGenresService() {
        return genreRepository.findAll();
    }

    public Optional<Genre> getGenreById(long id) throws InvalidException {

        Optional<Genre> genreOptional = genreRepository.findById(id);

        Genre genre = new Genre();

        if (genreOptional.isPresent()) {
            genre = genreOptional.get();
        } else {
            throw new InvalidException("Can not file genre with id = " + id);
        }

        Movie[] movies = webClientBuilder.build().get()
                .uri("lb://MovieService/api/v1/movies/{genreId}", id) // ✅ Dùng PathVariable đúng
                .retrieve()
                .bodyToMono(Movie[].class)
                .block();



        genre.setMovies(List.of(movies));


        return genreRepository.findById(id);
    }
}
