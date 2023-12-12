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
  genreSelected: string[] = [];
  isUpdate: boolean =false;

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

    this.movieService.create(data)
      .subscribe({
        next: (res) => {
          console.log(data);
          this.submitted = true;
          this.newMovie();
          this.router.navigate(['/movies']);
        },
        error: (e) => console.error(e)
      });
  }

  onSelectedGenre(item: any) {
    let genreId = item.target.value;
    if(!this.genreSelected.find(el => el == genreId)){
      this.genreSelected.push(genreId);
    }
      console.log(this.genreSelected);

  }

  newMovie():void {
    this.isUpdate = false;
    this.movie = {
      title: '',
      director:'',
      summary:'',
      genres:[]
    }
  }
}
