import { Component ,OnInit } from '@angular/core';
import {Genre} from "../../models/genre.model";
import {MovieService} from "../../services/movie.service";
import {Movie} from "../../models/movie.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-movies',
  templateUrl: './add-movies.component.html',
  styleUrl: './add-movies.component.css'
})
export class AddMoviesComponent implements OnInit {
  genreList?: Genre[];
  genreSelected?: Genre[];

  movie: Movie = {
    title: '',
    director:'',
    summary:'',
    genres:[]
  }
  submitted = false;

  constructor(private movieService: MovieService,private router: Router) {
  }
  ngOnInit(): void {
    this.getDataGenre();
  }

  getDataGenre(): void {
    this.movieService.getGenre()
      .subscribe({
        next: (result) => {
          this.genreList = result;
          // console.log(result);
        },
        error: (e) => console.error(e)
      });
  }

  saveTutorial(): void {
    const data = {
      title: this.movie.title,
      director: this.movie.director,
      summary: this.movie.summary,
      genres: this.genreSelected
    };
    // console.log(this.genreSelected);
    this.movieService.create(data)
      .subscribe({
        next: (res) => {
          this.submitted = true;
          this.newMovie();
          this.router.navigate(['/movies']);
        },
        error: (e) => console.error(e)
      });
  }

  onSelectedGenre(value: any):void {
    // if (this.genreSelected) {
    //   this.genreSelected.push(value);
    // }

    for(let i=0; i<value.length;i++){
      console.log(value[i].target.value);
    }
  }

  newMovie():void {
    this.submitted = false;
    this.movie = {
      title: '',
      director:'',
      summary:'',
      genres:[]
    }
  }
}
