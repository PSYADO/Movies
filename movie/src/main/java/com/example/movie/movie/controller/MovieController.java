package com.example.movie.movie.controller;

import com.example.movie.movie.domain.Movie;
import com.example.movie.movie.repository.MovieRepository;
import com.example.movie.movie.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.movie.movie.domain.TimeConverter;

import java.util.List;
import java.util.Optional;

@Controller
public class MovieController
{
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/movies")
    public String getAllMovies(Model model)
    {
        List<Movie> movies = movieRepository.findAll();
        model.addAttribute("movies", movies);
        return "movie list";
    }

    @GetMapping("/addMovie")
    public String addMovieForm(Model model)
    {
        Movie movie = new Movie();
        model.addAttribute("movie",movie);
        return "add movie";
    }

    @PostMapping("/saveMovie")
    public String saveMovie(@ModelAttribute("movie") Movie movie)
    {
        movieRepository.save(movie);
        return "redirect:/movies";
    }

    @GetMapping("/updateForm/{id}")
    public String updateMovieForm(@PathVariable Long id, Model model) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()) {
            model.addAttribute("movie", optionalMovie.get());
            return "update movie";
        } else {
            return "redirect:/movies";
        }
    }

    @PostMapping("/update/{id}")
    public String updateMovie(@PathVariable Long id, @ModelAttribute("movie") Movie updatedMovie) {
        Optional<Movie> optionalContact = movieRepository.findById(id);
        if (optionalContact.isPresent()) {
            Movie existingMovie = optionalContact.get();
            existingMovie.setName(updatedMovie.getName());
            existingMovie.setRating(updatedMovie.getRating());
            existingMovie.setAuthor(updatedMovie.getAuthor());
            existingMovie.setTotalTime(updatedMovie.getTotalTime());

            movieRepository.save(existingMovie);
        }
        return "redirect:/movies";
    }

    @GetMapping("/deleteForm/{id}")
    public String deleteMovieForm(@PathVariable Long id, Model model) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()) {
            model.addAttribute("movie", optionalMovie.get());
            return "delete movie";
        } else {
            return "redirect:/movies";
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()) {
            movieRepository.deleteById(id);
        }
        return "redirect:/movies";
    }
}
