package com.alexistdev.alexistdevsimplecrud.repository;

import com.alexistdev.alexistdevsimplecrud.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre,Integer> {
    Optional<Genre> findByName(String name);
}
