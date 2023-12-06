package com.alexistdev.alexistdevsimplecrud.genre;

import com.alexistdev.alexistdevsimplecrud.entity.Genre;
import com.alexistdev.alexistdevsimplecrud.repository.GenreRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class GenreRepositoryTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private GenreRepository genreRepository;

    private Genre genre;

    @BeforeEach
    void setUp() {
        genre = Genre.builder()
                .id("1")
                .name("horor")
                .build();
        em.persist(genre);
        em.flush();
    }

    @Test
    @DisplayName("testing findByName")
    public void findByNameTest() {
        Genre genreFound = genreRepository.findByName("horor").orElse(null);
        assert genreFound != null;
        Assertions.assertSame(genreFound.getName(),"horor");
    }
}
