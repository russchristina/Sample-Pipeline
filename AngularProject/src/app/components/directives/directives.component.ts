import { Component, OnInit } from '@angular/core';
import { Movie } from 'src/app/classes/Movie';

@Component({
  selector: 'app-directives',
  templateUrl: './directives.component.html',
  styleUrls: ['./directives.component.css']
})
export class DirectivesComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  visible:boolean = false;

  movie:Movie = new Movie(1, "The Longest Foot", 0, "Some Image", 1);

  movies:Movie[] = [];

  styleObject = {
    color:"blue",
    backgroundColor:"green"
  }

  colorToggle:boolean = false;
  changeStyle(){
    if(this.colorToggle = !this.colorToggle){
      this.styleObject.color = "green";
      this.styleObject.backgroundColor = "blue";
    }else{
      this.styleObject.color = "blue";
      this.styleObject.backgroundColor = "green";
    }
  }

  submitMovie(){
    this.movies.push(
      new Movie(
        this.movie.id,
        this.movie.name,
        this.movie.rating,
        this.movie.image,
        this.movie.date
      )
    );
        this.movie.id = 0;
        this.movie.name = "";
        this.movie.rating = 0;
        this.movie.image = "";
        this.movie.date = 0;
  }

  toggleTransparency(){
    this.visible = !this.visible;
  }
}
