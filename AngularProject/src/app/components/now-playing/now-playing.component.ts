import { Component, OnInit } from '@angular/core';
import { MovieService } from 'src/app/services/movie.service';

/**Decorators mark the class as a component that the Angular Framework should manage the life cycle of. */
@Component({
  selector: 'app-now-playing',
  templateUrl: './now-playing.component.html',
  styleUrls: ['./now-playing.component.css']
})
export class NowPlayingComponent implements OnInit {

  /**Let's inject a private instance of our movie service so that we can access our movie service's functions in this component. */
  constructor(private ms:MovieService) { }
//An array that will hold the data we've received from the server
  private nowPlaying:any[];
  private nowVisiblePlaying:any[] = [];

  ngOnInit() {
    this.getNowPlaying("Avengers");
    console.log(this.nowPlaying);
    // this.populateVisibleNowPlaying();
  }

  getNowPlaying(movieParam:string){
    /**This "subscribe" method is used with Observables in Angular. Observables are a way of handling asynchronous requests to servers and aysnc data.
     * 
     * In fact, there are two ways of handling async data/requests: Observables and Promises.
     * 
     * Promises vs Observables:
     * 
     * PROMISES: Promises can only accept one response from the server and are not cancellable. They can only be resolved once. Are supported in JavaScript.
     * 
     * OBSERVABLES: Observables can actually await multiple responses from server and are cancellable. 
    */
    return this.ms.getNowPlaying(movieParam).subscribe(
      data => {
        this.nowPlaying = data["Search"];
        console.log(this.nowPlaying);
        this.populateVisibleNowPlaying();
      },
      error => {
        error = "Couldn't retrieve movies that are currently available.";
        console.log(error);
      }
    )
  }

  populateVisibleNowPlaying(){
    for(let i = 0; i <= 3; i++){
      this.nowVisiblePlaying.push(this.nowPlaying[i]);
      console.log(this.nowVisiblePlaying);
    }
  }
}
