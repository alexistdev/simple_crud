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

    @Override
    public Movie update(Movie movie, int id) throws Exception {
        Movie movieData = movieRepository.findById(id).orElse(null);
        if(movieData == null){
           throw new Exception("Not Found");
        }
        movieData.setSummary(movie.getSummary());
        movieData.setGenres(movie.getGenres());
        movieData.setDirector(movie.getDirector());
        movieData.setTitle(movie.getTitle());
        movieRepository.save(movieData);
        return movieData;
    }
}
