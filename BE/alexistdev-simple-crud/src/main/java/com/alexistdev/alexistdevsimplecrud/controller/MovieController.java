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
import java.util.Optional;
import java.util.ResourceBundle;

@Slf4j
@RestController
@RequestMapping("/api")
public class MovieController {

    public static final String MOVIE ="/movie";

    public static final String GET_MOVIE_LISTS = "/lists";

    @Autowired
    private MovieService movieService;

    @PostMapping(value=MOVIE)
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

    @PatchMapping(value = MOVIE+"/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Movie movie, @PathVariable int id){
        ResponseData<Movie> responseData = new ResponseData<>();
        responseData.setStatus(false);
        try{
            Movie result = movieService.update(movie,id);
            responseData.setStatus(true);
            responseData.setData(result);
            responseData.setMessages(ResourceBundle.getBundle("message").getString("success"));
            return new ResponseEntity<ResponseData<?>>(responseData, HttpStatus.CREATED);
        } catch (Exception e) {
//            responseData.setMessages(ResourceBundle.getBundle("message").getString("failed"));
            responseData.setMessages(e.getMessage());
            return new ResponseEntity<ResponseData<?>>(responseData, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = GET_MOVIE_LISTS)
    public ResponseEntity<?> getMovie() throws Exception {
        ResponseData<List<Movie>> responseData= new ResponseData<>();
        List<Movie> result = movieService.getAll();
        if(result.isEmpty()){
            responseData.setStatus(false);
            responseData.setData(result);
            responseData.setMessages(ResourceBundle.getBundle("message").getString("empty"));
            return new ResponseEntity<ResponseData<?>>(responseData, HttpStatus.NOT_FOUND);
        }
        responseData.setStatus(true);
        responseData.setData(result);
        return new ResponseEntity<ResponseData<?>>(responseData, HttpStatus.CREATED);
    }

}
