import {Genre} from "./genre.model";

export class Moviepayload {
  id?: number;
  title?: string;
  director?: string;
  summary?: string;
  genres?: Genre[];
}
