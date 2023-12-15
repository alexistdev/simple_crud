import {Component, ViewChild} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Movie} from "../../models/movie.model";
import {MovieService} from "../../services/movie.service";
import {ModalDirective} from 'ngx-bootstrap/modal';
import {IDropdownSettings} from "ng-multiselect-dropdown";

@Component({
  selector: 'app-edit-movies',
  templateUrl: './edit-movies.component.html',
  styleUrl: './edit-movies.component.css'
})
export class EditMoviesComponent {

  movieData?: Movie = new Movie();
  idMovie?: string | null;
  genreSelected?: string[] = [];
  dropdownSettings:IDropdownSettings={};

  @ViewChild('modalDelete') public modalDelete?:ModalDirective;

  constructor(modalDelete:ModalDirective, private movieService: MovieService,private route: ActivatedRoute, private route2: Router) {}

  ngOnInit(): void {
    this.dropdownSettings = {
      idField: 'id',
      textField: 'name',
    };
    this.idMovie = this.route.snapshot.paramMap.get('id');
    this.getById(Number(this.idMovie));
  }

  getById(id:number):void{
    this.movieService.getById(id)
      .subscribe({
        next: (result) => {
          this.movieData = result.data;
          console.log("genre : "+typeof this.movieData!.genres);
          console.log("data : " +typeof this.movieData);
        },
        error: (e) => console.error(e)
      });
  }

  delete(id:number | undefined):void{
    if(id != undefined){
      this.movieService.deleteById(id)
        .subscribe({
          next: (result) => {
          },
          error: (e) => console.error(e)
        });
    }
    this.route2.navigate(['/movies']);
    if (this.modalDelete instanceof ModalDirective) {
      this.modalDelete.hide();
    }
  }

  showModalDelete(): void {
    if (this.modalDelete instanceof ModalDirective) {
      this.modalDelete.show();
    }
  }

  hideModalDelete():void{
    if (this.modalDelete instanceof ModalDirective) {
      this.modalDelete.hide();
    }
  }


}
