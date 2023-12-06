package com.alexistdev.alexistdevsimplecrud.repository;

import com.alexistdev.alexistdevsimplecrud.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie,Integer> {

    Optional<Movie> findByTitle(String title);
}
