package com.alexistdev.alexistdevsimplecrud.dao;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MovieRequest {
    private String title;
    private String director;
    private String summary;
    private List<String> genres;
}
