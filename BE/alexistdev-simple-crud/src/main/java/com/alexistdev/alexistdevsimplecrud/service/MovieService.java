package com.alexistdev.alexistdevsimplecrud.service;

import com.alexistdev.alexistdevsimplecrud.dao.MovieRequest;
import com.alexistdev.alexistdevsimplecrud.dao.MovieResponse;
import com.alexistdev.alexistdevsimplecrud.entity.Movie;

import java.util.List;

public interface MovieService {
    Movie save(MovieRequest movie) throws Exception;

    List<Movie> getAll() throws Exception;

    Movie update(Movie movie, int id) throws Exception;

    List<Movie> findByFilter(String filter) throws Exception;

    Movie findById(int id)throws Exception;
}
