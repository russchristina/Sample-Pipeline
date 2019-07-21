import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DatabindingComponent } from './components/databinding/databinding.component';
import { DirectivesComponent } from './components/directives/directives.component';
import { NowPlayingComponent } from './components/now-playing/now-playing.component';

/*This is where we set up our Angular routes. Remember that Angular lets us develop single page applications. In order to achieve single page application functionality, Angular uses routes. These routes are injected into the single page (index.html).*/
const routes: Routes = [
  {
    component: DatabindingComponent,
    path: "data-binding"
  },
  {
    component: DirectivesComponent,
    path: "directives"
  },
  {
    component: NowPlayingComponent,
    path: "now-playing"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
