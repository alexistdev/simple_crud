package com.alexistdev.alexistdevsimplecrud.service;

import com.alexistdev.alexistdevsimplecrud.entity.Genre;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


public interface GenreService {
    Genre save(Genre genre) throws Exception;

}
