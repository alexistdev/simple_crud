package com.alexistdev.alexistdevsimplecrud.controller;

import com.alexistdev.alexistdevsimplecrud.commonresponse.ResponseData;
import com.alexistdev.alexistdevsimplecrud.entity.Movie;
import com.alexistdev.alexistdevsimplecrud.service.MovieService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ResourceBundle;

@Slf4j
@RestController
@RequestMapping("/api")
public class MovieController {

    public static final String MOVIE_POST ="/movie";

    public static final String GET_MOVIE_LISTS = "/lists";

    @Autowired
    private MovieService movieService;

    @PostMapping(value=MOVIE_POST)
    public ResponseEntity<?> created(@Valid @RequestBody Movie movie){
        ResponseData<Movie> responseData= new ResponseData<>();
        responseData.setStatus(false);
        try {
            Movie result = movieService.save(movie);
            responseData.setStatus(true);
            responseData.setData(result);
            responseData.setMessages(ResourceBundle.getBundle("message").getString("success"));
            return new ResponseEntity<ResponseData<?>>(responseData, HttpStatus.CREATED);
        }catch (Exception e){
            responseData.setMessages(ResourceBundle.getBundle("message").getString("failed"));
            return new ResponseEntity<ResponseData<?>>(responseData, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = GET_MOVIE_LISTS)
    public ResponseEntity<?> getMovie() throws Exception {
        ResponseData<List<Movie>> responseData= new ResponseData<>();
        List<Movie> result = movieService.getAll();
        responseData.setStatus(true);
        responseData.setData(result);
        return new ResponseEntity<ResponseData<?>>(responseData, HttpStatus.CREATED);
    }

}
