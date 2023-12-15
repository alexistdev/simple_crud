import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MoviesListComponent } from './components/movies-list/movies-list.component';
import { AddMoviesComponent } from './components/add-movies/add-movies.component';
import { FormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { EditMoviesComponent } from './components/edit-movies/edit-movies.component';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';
import {ModalDirective, ModalModule} from "ngx-bootstrap/modal";

@NgModule({
  declarations: [
    AppComponent,
    MoviesListComponent,
    AddMoviesComponent,
    EditMoviesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ModalModule.forRoot(),
    NgMultiSelectDropDownModule.forRoot()
  ],
  providers: [ModalDirective],
  bootstrap: [AppComponent]
})
export class AppModule { }
