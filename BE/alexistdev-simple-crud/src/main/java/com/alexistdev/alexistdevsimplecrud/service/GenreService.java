package com.alexistdev.alexistdevsimplecrud.service;

import com.alexistdev.alexistdevsimplecrud.entity.Genre;
import com.alexistdev.alexistdevsimplecrud.entity.Movie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


public interface GenreService {
    Genre save(Genre genre) throws Exception;
    List<Genre> getAll() throws Exception;
}
