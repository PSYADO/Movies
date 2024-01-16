package com.example.movie.movie.services;

import com.example.movie.movie.domain.Movie;
import com.example.movie.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService
{
    @Autowired
    MovieRepository movieRepository;

    @Override
    public Movie saveMovie(Movie movie)
    {
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> saveMovies(List<Movie> movies)
    {
        return movieRepository.saveAll(movies);
    }

    @Override
    public Movie getMovieById(long id)
    {
        Optional<Movie> movie = movieRepository.findById(id);

        Movie emptyMovie;
        if(movie.isPresent())
        {
            emptyMovie = movie.get();
            return emptyMovie;
        }
        else
        {
            throw new RuntimeException("Movie Not Found");
        }
    }

    @Override
    public List<Movie> getAllMovies()
    {
        return movieRepository.findAll();
    }

    @Override
    public Movie updateMovie(Movie movie)
    {
        Optional<Movie> optionalMovie = movieRepository.findById(movie.getId());
        if (optionalMovie.isPresent())
        {
            Movie updateMovie = optionalMovie.get();
            updateMovie.setName(movie.getName());
            updateMovie.setAuthor(movie.getAuthor());
            updateMovie.setTotalTime(movie.getTotalTime());

            movieRepository.save(updateMovie);
            return updateMovie;
        }
        else
        {
            throw new RuntimeException("Movie does not exist");
        }
    }

    @Override
    public void deleteMovie(long id)
    {
        movieRepository.deleteById(id);
    }

    public void deleteMovies()
    {
        movieRepository.deleteAll();
    }
}
