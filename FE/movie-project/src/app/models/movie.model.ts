import {Genre} from "./genre.model";
import {Type} from "@angular/core";

export class Movie {
  id?: number;
  title?: string;
  director?: string;
  summary?: string;
  genres?: Genre[];
}
