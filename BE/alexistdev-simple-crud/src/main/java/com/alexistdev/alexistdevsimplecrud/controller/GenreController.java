package com.alexistdev.alexistdevsimplecrud.controller;

import com.alexistdev.alexistdevsimplecrud.commonresponse.ResponseData;
import com.alexistdev.alexistdevsimplecrud.entity.Genre;
import com.alexistdev.alexistdevsimplecrud.service.GenreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ResourceBundle;

@Slf4j
@RestController
@RequestMapping("/api")
public class GenreController {
    public static final String GENRE ="/genre";

    @Autowired
    private GenreService genreService;

    @GetMapping(value = GENRE)
    public ResponseEntity<List<Genre>> getMovie() throws Exception {
        ResponseData<List<Genre>> responseData= new ResponseData<>();
        List<Genre> result = genreService.getAll();
        if(result.isEmpty()){
            responseData.setStatus(false);
            responseData.setData(result);
            responseData.setMessages(ResourceBundle.getBundle("message").getString("empty"));
            return new ResponseEntity<List<Genre>>(result, HttpStatus.NO_CONTENT);
        }
        responseData.setStatus(true);
        responseData.setData(result);
        return new ResponseEntity<List<Genre>>(result, HttpStatus.CREATED);
    }

}
