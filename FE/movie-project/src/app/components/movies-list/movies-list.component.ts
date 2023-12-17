import {Component, OnDestroy, OnInit} from '@angular/core';
import {Movie} from "../../models/movie.model";
import {MovieService} from "../../services/movie.service";
import {Moviepayload} from "../../models/moviepayload.model";
import {Router} from "@angular/router";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-movies-list',
  templateUrl: './movies-list.component.html',
  styleUrl: './movies-list.component.css'
})
export class MoviesListComponent implements OnInit,OnDestroy {

  movieslist?: Moviepayload[];
  currentIndex = -1;
  title = '';
  subs?: Subscription = new Subscription();

  constructor(private movieService: MovieService,private router: Router) {
  }

  ngOnInit(): void {
    this.getDataMovies();
  }

  ngAfterViewInit():void{
    this.getDataMovies();
  }

  getDataMovies(): void {
    this.subs = this.movieService.getAll()
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

  setActiveMovie(movie: Moviepayload): void {
      this.router.navigateByUrl('/movies/'+movie.id);
  }

  ngOnDestroy(): void {
    this.subs?.unsubscribe();
  }



}
