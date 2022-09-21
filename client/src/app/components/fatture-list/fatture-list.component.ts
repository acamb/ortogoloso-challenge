import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Fattura } from 'src/app/model/Fattura';
import { FatturaService } from 'src/app/service/fattura.service';
import { firstValueFrom } from 'rxjs';
/**
 * Componente che elenca le fatture ed orchestra il routing verso il dettaglio e le operazioni sulle fatture
 */
@Component({
  selector: 'app-fatture-list',
  templateUrl: './fatture-list.component.html',
  styleUrls: ['./fatture-list.component.css']
})
export class FattureListComponent implements OnInit {

  fatture: Observable<Array<Fattura>>;

  constructor(private fatturaService: FatturaService,private router: Router) {
    this.fatture = fatturaService.getAll();
   }

  ngOnInit(): void {
  }

  async onRemoveFattura(fattura: Fattura){
    await firstValueFrom(this.fatturaService.delete(fattura));
    this.fatture = this.fatturaService.getAll();
  }

  onSelectFattura(fattura: Fattura){
    this.router.navigateByUrl("fattura/"+fattura.id);
  }

  onNuovaFattura(){
    this.router.navigateByUrl("fattura/");
  }

}
