import { Component,OnInit } from '@angular/core';
import {HttpClient, HttpClientModule} from '@angular/common/http';



@Component({
  selector: 'app-home',
  standalone: true,
  imports: [HttpClient],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit  {


  constructor(

  ) {
  }

  ngOnInit(): void {
    // this.movieService.getMovies().subscribe((movies) => {
    //   this.movies = movies;
    // })
    // console.log("testing");

  }




}
