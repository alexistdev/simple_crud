import {Component, ViewChild} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Movie} from "../../models/movie.model";
import {MovieService} from "../../services/movie.service";
import {ModalDirective} from 'ngx-bootstrap/modal';
import {IDropdownSettings} from "ng-multiselect-dropdown";
import {Genre} from "../../models/genre.model";

@Component({
  selector: 'app-edit-movies',
  templateUrl: './edit-movies.component.html',
  styleUrl: './edit-movies.component.css'
})
export class EditMoviesComponent {

  movieData?: Movie = new Movie();
  idMovie?: string | null;
  genreSelected: string[] = [];
  dropdownSettings:IDropdownSettings={};
  genreList?: any;

  movie: Movie = {
    title: '',
    director:'',
    summary:'',
    genres:[]
  }

  @ViewChild('modalDelete') public modalDelete?:ModalDirective;

  constructor(modalDelete:ModalDirective, private movieService: MovieService,private route: ActivatedRoute, private route2: Router) {}

  ngOnInit(): void {
    this.dropdownSettings = {
      idField: 'id',
      textField: 'name',
    };
    this.getDataGenre();
    this.idMovie = this.route.snapshot.paramMap.get('id');
    this.getById(Number(this.idMovie));
  }

  getById(id:number):void{
    this.movieService.getById(id)
      .subscribe({
        next: (result) => {
          this.movieData = result.data;
          // console.log("genre : "+typeof this.movieData!.genres);
          // console.log("data : " +typeof this.movieData);
        },
        error: (e) => console.error(e)
      });
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
    // this.route2.navigate('/movies');
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

  newMovie():void {
    this.movie = {
      title: '',
      director:'',
      summary:'',
      genres:[]
    }
  }

  saveTutorial(): void {
    const dataMovie = {
      title: this.movieData!.title,
      director: this.movieData!.director,
      summary: this.movieData!.summary,
      genres: this.genreSelected
    };
    this.movieService.updateMovie(dataMovie,Number(this.idMovie))
      .subscribe({
        next: (res) => {
          console.log("testing");
          console.log(dataMovie);
          this.newMovie();
          this.route2.navigate(['/movies']);
        },
        error: (e) => console.error(e)
      });
  }

}
