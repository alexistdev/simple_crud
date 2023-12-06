package com.alexistdev.alexistdevsimplecrud.genre;

import com.alexistdev.alexistdevsimplecrud.entity.Genre;
import com.alexistdev.alexistdevsimplecrud.repository.GenreRepository;
import com.alexistdev.alexistdevsimplecrud.service.GenreImplementation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GenreServiceTest {

    @Mock
    private GenreRepository genreRepository;

    @InjectMocks
    private GenreImplementation genreService;

    private Genre genre;

    @BeforeEach
    void setUp() {
        genreService = new GenreImplementation(genreRepository);
        genre =Genre.builder()
                .name("tidak horor")
                .build();
    }

    @Test
    @DisplayName("Save Genre")
    void saveGenreTest() {
        Genre created = genreService.save(genre);
        Assertions.assertNotNull(created);
    }

    @Test
    @DisplayName("Duplicate Name Genre")
    void duplicate_name_throw_error() {
        Genre genre2 = Genre.builder().name("horor").build();
        when(genreRepository.findByName(anyString())).thenReturn(Optional.of(genre2));
        Assertions.assertThrows(RuntimeException.class, ()->{
            genreService.save(genre);
        });
    }
}
