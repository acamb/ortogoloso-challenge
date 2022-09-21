import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FatturaViewComponent } from './components/fattura-view/fattura-view.component';
import { FattureListComponent } from './components/fatture-list/fatture-list.component';

const routes: Routes = [
  {
    path: 'fattura/:id',
    component: FatturaViewComponent
  },
  {
    path: '',
    component: FattureListComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
