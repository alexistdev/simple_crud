package com.alexistdev.alexistdevsimplecrud.repository;

import com.alexistdev.alexistdevsimplecrud.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Integer> {
    Optional<Genre> findByName(String name);
}
