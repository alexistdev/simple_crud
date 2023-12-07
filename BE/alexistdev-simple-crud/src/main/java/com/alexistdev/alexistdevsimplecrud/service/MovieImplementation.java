package com.alexistdev.alexistdevsimplecrud.service;

import com.alexistdev.alexistdevsimplecrud.entity.Movie;
import com.alexistdev.alexistdevsimplecrud.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieImplementation implements MovieService{
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie save(Movie movie) throws Exception {
        Movie created = new Movie();
        created.setTitle(movie.getTitle());
        created.setDirector(movie.getDirector());
        created.setSummary(movie.getSummary());
        created.setGenres(movie.getGenres());
        movieRepository.save(created);
        return created;
    }

    @Override
    public List<Movie> getAll() throws Exception {
        return movieRepository.findAll();
    }
}
