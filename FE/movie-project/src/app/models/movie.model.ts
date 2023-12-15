import {Genre} from "./genre.model";

export class Movie {
  id?: number;
  title?: string ;
  director?: string;
  summary?: string;
  genres?: Genre[];
}
