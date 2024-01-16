package com.example.movie.movie.controller.api;

import com.example.movie.movie.domain.Movie;
import com.example.movie.movie.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieAPIController
{
    @Autowired
    MovieService movieService;

    @GetMapping("/getMovies")
    public ResponseEntity<List<Movie>> getAllMovies()
    {
        return ResponseEntity.ok().body(movieService.getAllMovies());
    }

    @GetMapping("/getMovie/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable long id)
    {
        return ResponseEntity.ok().body(movieService.getMovieById(id));
    }

    @PostMapping("/addMovie")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie)
    {
        return ResponseEntity.ok().body(movieService.saveMovie(movie));
    }

    @PostMapping("/addMovies")
    public List<Movie> addMovies(@RequestBody List<Movie> movies)
    {
        return movieService.saveMovies(movies);
    }

    @PutMapping("/updateMovie/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable long id, @RequestBody Movie movie)
    {
        return ResponseEntity.ok().body(movieService.updateMovie(movie));
    }

    @DeleteMapping("/deleteMovie/{id}")
    public HttpStatus deleteMovie(@PathVariable long id)
    {
        movieService.deleteMovie(id);
        return HttpStatus.OK;
    }

    @DeleteMapping("/deleteMovies")
    public String deleteMovies()
    {
        movieService.deleteMovies();
        return "All Movies have been  deleted";
    }
}
