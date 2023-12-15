package com.alexistdev.alexistdevsimplecrud.service;

import com.alexistdev.alexistdevsimplecrud.dao.MovieRequest;
import com.alexistdev.alexistdevsimplecrud.dao.MovieResponse;
import com.alexistdev.alexistdevsimplecrud.entity.Genre;
import com.alexistdev.alexistdevsimplecrud.entity.Movie;
import com.alexistdev.alexistdevsimplecrud.repository.GenreRepository;
import com.alexistdev.alexistdevsimplecrud.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MovieImplementation implements MovieService{
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public Movie save(MovieRequest movie) throws Exception {
        Movie created = new Movie();
        List<Genre> genreList = new ArrayList<>();
        for(String a: movie.getGenres()){
            Genre tempGenre = new Genre();
            tempGenre = genreRepository.findById(Integer.parseInt(a)).orElse(null);
            genreList.add(tempGenre);
        }
        created.setTitle(movie.getTitle());
        created.setDirector(movie.getDirector());
        created.setSummary(movie.getSummary());
        created.setGenres(genreList);
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

    @Override
    public List<Movie> findByFilter(String filter) throws Exception {
        List<Movie> result = movieRepository.findByTitleContaining(filter);
        log.info(result.toString());
        log.info(filter);
        return result;
    }

    @Override
    public Movie findById(int id) throws Exception {
        return movieRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) throws Exception {
        Movie result = movieRepository.findById(id).orElse(null);
        if(result == null){
            throw new RuntimeException("Not Found");
        }
        movieRepository.delete(result);
    }
}
