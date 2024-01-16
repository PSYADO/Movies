package com.example.movie.movie.services;

import com.example.movie.movie.domain.Movie;

import java.util.List;

public interface MovieService
{
    Movie saveMovie(Movie movie);
    List<Movie> saveMovies(List<Movie> movies);
    Movie getMovieById(long id);
    List<Movie> getAllMovies();
    Movie updateMovie(Movie movie);
    void deleteMovie(long id);
    void deleteMovies();
}