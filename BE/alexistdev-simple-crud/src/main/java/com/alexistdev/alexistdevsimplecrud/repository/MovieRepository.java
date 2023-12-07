package com.alexistdev.alexistdevsimplecrud.repository;

import com.alexistdev.alexistdevsimplecrud.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie,Integer> {

    List<Movie> findByTitleContaining(String title);
}
