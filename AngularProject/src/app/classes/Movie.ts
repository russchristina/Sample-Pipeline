/*We can create our own classes in TypeScript. Let's create a movie class here:*/

export class Movie{
    public id:number;
    public name:string;
    public rating:number;
    public image:string;
    public date:number;

    constructor(id:number, name:string, rating:number, image:string, date:number){
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.image = image;
        this.date = Date.now();
    }
}