import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Movie } from "../models/movie.model";
import {Genre} from "../models/genre.model";
import {Moviepayload} from "../models/moviepayload.model";

const movie_url = 'http://localhost:8901/api/lists';
const genre_url = 'http://localhost:8901/api/genre';
const movie_create_url = 'http://localhost:8901/api/movie';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Moviepayload[]> {
    return this.http.get<Moviepayload[]>(movie_url);
  }

  getGenre(): Observable<Genre[]>{
    return this.http.get<Genre[]>(genre_url);
  }

  create(data: any): Observable<any> {
    return this.http.post(movie_create_url, data);
  }

}
