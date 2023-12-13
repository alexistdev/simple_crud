package com.alexistdev.alexistdevsimplecrud.controller;

import com.alexistdev.alexistdevsimplecrud.commonresponse.ResponseData;
import com.alexistdev.alexistdevsimplecrud.dao.MovieRequest;
import com.alexistdev.alexistdevsimplecrud.dao.MovieResponse;
import com.alexistdev.alexistdevsimplecrud.entity.Genre;
import com.alexistdev.alexistdevsimplecrud.entity.Movie;
import com.alexistdev.alexistdevsimplecrud.service.MovieService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

@Slf4j
@RestController
@RequestMapping("/api")
public class MovieController {

    public static final String MOVIE ="/movie";

    public static final String GET_BY_ID ="/movie";

    public static final String GET_MOVIE_LISTS = "/lists";
    public static final String GET_MOVIE_LISTS_FILTER = "/lists/filter";

    @Autowired
    private MovieService movieService;

    @PostMapping(value=MOVIE)
    public ResponseEntity<?> created(@Valid @RequestBody MovieRequest request){
        ResponseData<Movie> responseData= new ResponseData<>();
        responseData.setStatus(false);
        try {
            Movie result = movieService.save(request);
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
            responseData.setMessages(e.getMessage());
            return new ResponseEntity<ResponseData<?>>(responseData, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = GET_MOVIE_LISTS)
    public ResponseEntity<List<Movie>> getMovie() throws Exception {
        ResponseData<List<Movie>> responseData= new ResponseData<>();
        List<Movie> result = movieService.getAll();
        if(result.isEmpty()){
            responseData.setStatus(false);
            responseData.setData(result);
            responseData.setMessages(ResourceBundle.getBundle("message").getString("empty"));
            return new ResponseEntity<List<Movie>>(result, HttpStatus.NO_CONTENT);
        }
        responseData.setStatus(true);
        responseData.setData(result);
        return new ResponseEntity<List<Movie>>(result, HttpStatus.CREATED);
    }

    @GetMapping(value = GET_MOVIE_LISTS_FILTER,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Movie>> getByFilter(@RequestParam(name = "filter",defaultValue = "") String filter) throws Exception{
        log.info(filter);
        ResponseData<List<Movie>> responseData= new ResponseData<>();
        List<Movie> result = movieService.findByFilter(filter);
        if(result.isEmpty()){
            responseData.setStatus(false);
            responseData.setData(result);
            responseData.setMessages(ResourceBundle.getBundle("message").getString("empty"));
            return new ResponseEntity<List<Movie>>(result, HttpStatus.NO_CONTENT);
        }
        responseData.setStatus(true);
        responseData.setData(result);
        return new ResponseEntity<List<Movie>>(result, HttpStatus.CREATED);
    }

}
