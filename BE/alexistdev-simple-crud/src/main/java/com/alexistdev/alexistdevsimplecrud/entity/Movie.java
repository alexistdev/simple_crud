package com.alexistdev.alexistdevsimplecrud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name="movies")
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty(message = "Name is required")
    @Column(name="title",unique = true)
    private String title;

    @NotEmpty(message = "Director is required")
    @Column(name="director")
    private String director;

    @NotEmpty(message = "Summary is required")
    @Column(name="summary",columnDefinition="CHAR(100)")
    private String summary;

    @ManyToMany
    @JoinTable(
            name = "movies_genres",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres;

}
