import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ActivatedRouteSnapshot, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Dettaglio } from 'src/app/model/Dettaglio';
import { Fattura } from 'src/app/model/Fattura';
import { DettaglioService } from 'src/app/service/dettaglio.service';
import { FatturaService } from 'src/app/service/fattura.service';
import { firstValueFrom } from 'rxjs';
import { of } from 'rxjs';
import { FatturaConDettagli } from 'src/app/model/FatturaConDettagli';
import { DettagliListResponse } from 'src/app/model/DettagliListResponse';

/**
 * Componente che orchestra la form della fattura e le operazioni sui dettagli, gestendo le chiamate ai service
 */
@Component({
  selector: 'app-fattura-view',
  templateUrl: './fattura-view.component.html',
  styleUrls: ['./fattura-view.component.css']
})
export class FatturaViewComponent implements OnInit {

  fattura: Observable<Fattura>;
  dettagli: Observable<DettagliListResponse>;
  idFattura: number;

  constructor(private route: ActivatedRoute,
    private fatturaService: FatturaService,
    private dettagliService: DettaglioService,
    private router: Router) {
    this.idFattura = Number.parseInt(route.snapshot.paramMap.get('id')!);
    if(this.idFattura){
      this.fattura = fatturaService.get(this.idFattura);
      this.dettagli = dettagliService.getAll(this.idFattura)
    }
    else{
      this.fattura = of(new Fattura());
    }
  }

  ngOnInit(): void {
  }

  async onDeleteDettaglio(dettaglio: Dettaglio){
    await this.dettagliService.delete(dettaglio);
    this.dettagli = this.dettagliService.getAll(this.idFattura);
  }

  async onSaveDettaglio(dettaglio: Dettaglio){
    await firstValueFrom(this.dettagliService.save(dettaglio,this.idFattura));
    this.dettagli = this.dettagliService.getAll(this.idFattura);
  }

  async onSaveDettaglioList(fatturaConDettagli: FatturaConDettagli){
    let fattura = await firstValueFrom(this.fatturaService.save(fatturaConDettagli.fattura))
    await firstValueFrom(this.dettagliService.saveAll(fatturaConDettagli.dettagli,fattura.id));
    this.dettagli = this.dettagliService.getAll(fattura.id);
  }

  onSaveFattura(fattura: Fattura){
    firstValueFrom(this.fatturaService.save(fattura));
    this.router.navigateByUrl("/")
  }

}
