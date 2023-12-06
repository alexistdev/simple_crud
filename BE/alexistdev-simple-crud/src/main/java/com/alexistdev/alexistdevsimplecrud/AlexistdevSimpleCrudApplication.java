package com.alexistdev.alexistdevsimplecrud;

import com.alexistdev.alexistdevsimplecrud.entity.Genre;
import com.alexistdev.alexistdevsimplecrud.repository.GenreRepository;
import com.alexistdev.alexistdevsimplecrud.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AlexistdevSimpleCrudApplication {



	public static void main(String[] args) {
		SpringApplication.run(AlexistdevSimpleCrudApplication.class, args);
	}

	@Autowired
	private GenreRepository genreService;

	@Bean
	CommandLineRunner seedGenre() {
		return args -> {
			List<String> name = Arrays.asList("Drama","Action","Animation","Sci-Fi","Horor");
			List<Genre> genres = new ArrayList<>();
			name.forEach((e)->{
				Genre genre = Genre.builder().name(e).build();
				genres.add(genre);
			});
			try {
				genreService.saveAll(genres);
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
		};
	}

}
