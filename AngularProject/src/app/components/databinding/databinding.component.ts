import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-databinding',
  templateUrl: './databinding.component.html',
  styleUrls: ['./databinding.component.css']
})
export class DatabindingComponent implements OnInit {

  constructor() { }

  /*
  This is our ngOnInit function. It is triggered whenever
  the component is instantiated. It works similarly to
  window.onload.
  */
  ngOnInit() {
  }

  //This is how we define a variable and its type in 
  //TypeScript
  variable:string = "Secret Message";
  visibility:boolean = true;
  userInput:string = "";

  //Access Modifiers and data types in TypeScript
  private vari:string;
  public vari2:number;
  protected vari3:boolean;
  private vari4:object;
  private vari5:null;
  private vari6:undefined;

  toggleVisibility(){
    this.visibility = !this.visibility;
  }
}
