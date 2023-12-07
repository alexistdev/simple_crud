import { Component, OnInit  } from '@angular/core';
import {Movie} from "../../models/movie.model";
import {MovieService} from "../../services/movie.service";

@Component({
  selector: 'app-movies-list',
  templateUrl: './movies-list.component.html',
  styleUrl: './movies-list.component.css'
})
export class MoviesListComponent implements OnInit {

  movieslist?: Movie[];
  currentMovie: Movie = {};
  currentIndex = -1;
  title = '';

  constructor(private movieService: MovieService) {
  }

  ngOnInit(): void {
    this.getDataMovies();
  }

  getDataMovies(): void {
    this.movieService.getAll()
      .subscribe({
        next: (result) => {
          this.movieslist = result;
        },
        error: (e) => console.error(e)
      });
  }

  filterResults(text: string) {
    if (text != "") {
      if (this.movieslist) {
        this.movieslist = this.movieslist.filter(
          movieslist => movieslist?.title?.toLowerCase().includes(text.toLowerCase())
        );
      }
    } else {
      this.getDataMovies();
    }

  }

  setActiveMovie(movie: Movie, index: number): void {
    this.currentMovie = movie;
    this.currentIndex = index;
  }

}
