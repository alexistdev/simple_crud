package com.alexistdev.alexistdevsimplecrud.service;

import com.alexistdev.alexistdevsimplecrud.entity.Movie;

import java.util.List;

public interface MovieService {
    Movie save(Movie movie) throws Exception;

    List<Movie> getAll() throws Exception;
}
