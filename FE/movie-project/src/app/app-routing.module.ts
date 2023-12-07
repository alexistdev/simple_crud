import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MoviesListComponent } from "./components/movies-list/movies-list.component";
import { AddMoviesComponent } from "./components/add-movies/add-movies.component";

const routes: Routes = [
  { path: '', redirectTo: 'movies', pathMatch: 'full' },
  { path: 'movies', component: MoviesListComponent },
  { path: 'movies/add', component: AddMoviesComponent },
  // { path: 'movies/:id', component: MoviesListComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
