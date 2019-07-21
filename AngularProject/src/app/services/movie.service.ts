import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';

/*Note this decorator. It tells the framework that this service can be injected into other components as a dependency.*/
@Injectable({
  providedIn: 'root'
})
export class MovieService {

  /*This is referred to as dependency injection. We've injected an HttpClient object into our Movie Service. As a result, whenever we instantiated a Movie Service object, an HttpClient will be created for us. It is the Angular Framework that does this for us.*/

  /** When you're using the HttpClient, it is actually using AJAX under the hood, simply abstracting AJAX away from you.*/
  constructor(private http:HttpClient) { }

  /*As I said earlier, services are just here to provide some functionality and be injected into components as dependencies. That said, let's create some functions.*/
  getNowPlaying(movieParam:string){
    const headers = new HttpHeaders().set("X-RapidAPI-Key", "2f530a3db3msh028512351081690p171600jsnf425ee1b906c")
    .set("X-RapidAPI-Host", "movie-database-imdb-alternative.p.rapidapi.com");

    const body = new HttpParams().set("s", movieParam);

    return this.http.get("http://localhost:8080/ServletDemo/getflixapi/movie/all", {headers:headers, params:body});
  }
}
