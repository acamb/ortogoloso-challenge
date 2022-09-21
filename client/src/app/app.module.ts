import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FattureListComponent } from './components/fatture-list/fatture-list.component';
import { FatturaViewComponent } from './components/fattura-view/fattura-view.component';
import { DettaglioViewComponent } from './components/dettaglio-view/dettaglio-view.component';
import { FatturaFormComponent } from './components/fattura-form/fattura-form.component';

@NgModule({
  declarations: [
    AppComponent,
    FattureListComponent,
    FatturaViewComponent,
    DettaglioViewComponent,
    FatturaFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
