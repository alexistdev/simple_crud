import { Component ,OnInit } from '@angular/core';
import {Genre} from "../../models/genre.model";
import {MovieService} from "../../services/movie.service";

@Component({
  selector: 'app-add-movies',
  templateUrl: './add-movies.component.html',
  styleUrl: './add-movies.component.css'
})
export class AddMoviesComponent implements OnInit {
  genreList?: Genre[];

  constructor(private movieService: MovieService) {
  }
  ngOnInit(): void {
    this.getDataGenre();
  }

  getDataGenre(): void {
    this.movieService.getGenre()
      .subscribe({
        next: (result) => {
          this.genreList = result;
          console.log(result);
        },
        error: (e) => console.error(e)
      });
  }
}
