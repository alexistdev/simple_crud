import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Movie } from "../models/movie.model";
import {Genre} from "../models/genre.model";

const movie_url = 'http://localhost:8901/api/lists';
const genre_url = 'http://localhost:8901/api/genre';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Movie[]> {
    return this.http.get<Movie[]>(movie_url);
  }

  getGenre(): Observable<Genre[]>{
    return this.http.get<Genre[]>(genre_url);
  }
}
