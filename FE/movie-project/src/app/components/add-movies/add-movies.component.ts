import { Component ,OnInit } from '@angular/core';
import {Genre} from "../../models/genre.model";
import {MovieService} from "../../services/movie.service";
import {Movie} from "../../models/movie.model";
import {Router} from "@angular/router";
import { IDropdownSettings } from 'ng-multiselect-dropdown';

@Component({
  selector: 'app-add-movies',
  templateUrl: './add-movies.component.html',
  styleUrl: './add-movies.component.css'
})
export class AddMoviesComponent implements OnInit {
  genreList?: any;
  genreSelected: string[] = [];

  dropdownSettings:IDropdownSettings={};

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
    this.dropdownSettings = {
      idField: 'id',
      textField: 'name',
    };
  }

  onItemDeSelect(item: any){
    let genreId = item.id;
    for(let i=0; i < this.genreSelected.length ;i++){
      if(this.genreSelected[i] == genreId){
        this.genreSelected.splice(i,1);
      }
    }
  }

  onItemSelect(item: any) {
    let genreId = item.id;
    if(!this.genreSelected.find(el => el == genreId)){
      this.genreSelected.push(genreId);
    }
  }

  onSelectAll(items: any) {
    if(items.length > 0){
      for(let i=0 ; i < items.length ; i++){
        let genreId = items[i].id;
        if(!this.genreSelected.find(el => el == genreId)){
          this.genreSelected.push(genreId);
        }
      }
    }
  }

  onUnSelectAll() {
    this.genreSelected = [];
  }

  getDataGenre(): void {
    this.movieService.getGenre()
      .subscribe({
        next: (result) => {
          // this.genreList = result;
          this.genreList = result?.map((item: Genre) => item).filter((y) => y !== undefined) ?? [];
        },
        error: (e) => console.error(e)
      });
  }

  saveTutorial(): void {
    const dataMovie = {
      title: this.movie.title,
      director: this.movie.director,
      summary: this.movie.summary,
      genres: this.genreSelected
    };

    this.movieService.create(dataMovie)
      .subscribe({
        next: (res) => {
          console.log(dataMovie);
          this.submitted = true;
          this.newMovie();
          this.router.navigate(['/movies']);
        },
        error: (e) => console.error(e)
      });
  }

  newMovie():void {
    this.movie = {
      title: '',
      director:'',
      summary:'',
      genres:[]
    }
  }
}
