package com.alexistdev.alexistdevsimplecrud.service;

import com.alexistdev.alexistdevsimplecrud.entity.Genre;
import com.alexistdev.alexistdevsimplecrud.repository.GenreRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.ResourceBundle;


@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Service
public class GenreImplementation implements GenreService{

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public Genre save(Genre genre) throws RuntimeException {
        Optional<Genre> cekGenre = genreRepository.findByName(genre.getName());
        if(cekGenre.isPresent()){
            String name = cekGenre.map(Genre::getName).orElse(null);
            log.error(ResourceBundle.getBundle("message").getString("duplicate"));
            throw new RuntimeException(name+ ResourceBundle.getBundle("message"));
        }
        Genre result = Genre.builder()
                .name(genre.getName())
                .build();
        genreRepository.save(result);
        return result;
    }
}
