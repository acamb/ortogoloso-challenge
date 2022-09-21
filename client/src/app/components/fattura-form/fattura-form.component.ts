import { Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChange, SimpleChanges } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Dettaglio } from 'src/app/model/Dettaglio';
import { Fattura, ModalitaPagamento } from 'src/app/model/Fattura';
import { of } from 'rxjs';
import { FatturaConDettagli } from 'src/app/model/FatturaConDettagli';
import { DettagliListResponse } from 'src/app/model/DettagliListResponse';
/**
 * Componente che gestisce la visualizzazione dei dati della fattura
 */
@Component({
  selector: 'app-fattura-form',
  templateUrl: './fattura-form.component.html',
  styleUrls: ['./fattura-form.component.css']
})
export class FatturaFormComponent implements OnInit,OnChanges {

  @Input() fattura: Fattura | null = new Fattura();
  @Input() dettagli: DettagliListResponse | null;

  @Output() saveFattura = new EventEmitter<Fattura>();
  @Output() saveDettaglio = new EventEmitter<Dettaglio>();
  @Output() saveFatturaConDettagli = new EventEmitter<FatturaConDettagli>();
  @Output() deleteDettaglio = new EventEmitter<Dettaglio>();

  dettaglioVisible=false;
  modalitaPagamentoList = ModalitaPagamento
  //Nel caso in cui non ho ancora salvato la fattura per la prima volta, tengo in memoria i dettagli per salvarli in blocco al salvataggio
  //altrimenti non avrei un id fattura da agganciarci.
  _dettagliList : Dettaglio[] = [];
  keys = Object.keys
  totale = 0;


  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  ngOnChanges(changes: SimpleChanges){
    if(this.dettagli){
      this.totale = this.dettagli.totale;
    }
    if(this.fattura){
    this.fattura.importo = this.totale;
    }
  }

  onSubmit(form: NgForm){
    if(form.valid){
      if(this.fattura!.id){
      this.saveFattura.emit(this.fattura!)
      }
      else{
        this.saveFatturaConDettagli.emit({
          fattura: this.fattura!,
          dettagli: this._dettagliList
        })
      }
      
    }
  }  

  onBack(){
    this.router.navigateByUrl("/");
  }

  onRemoveDettaglio(dettaglio: Dettaglio){
    if(this.fattura!.id){
      this.deleteDettaglio.emit(dettaglio);
    }
    else{
      this._dettagliList = this._dettagliList.filter(d => d === dettaglio)
      this.totale=this._dettagliList.map(d => d.importo*d.quantita).reduce((sum,current)=> sum+current)
      this.dettagli = { dettagli: this._dettagliList,totale: this._dettagliList.map(d => d.importo*d.quantita).reduce((sum,current)=> sum+current) }
    }
  }

  showDettaglio(){
    this.dettaglioVisible=true;
  }

  onSaveDettaglio(dettaglio:Dettaglio){
    if(this.fattura!.id){
      this.saveDettaglio.emit(dettaglio);
    }
    else{
      this._dettagliList.push(dettaglio);
      this.totale=this._dettagliList.map(d => d.importo*d.quantita).reduce((sum,current)=> sum+current)
      this.dettagli = { dettagli: this._dettagliList,totale: this._dettagliList.map(d => d.importo*d.quantita).reduce((sum,current)=> sum+current) }
    }
    this.dettaglioVisible=false;
  }

  onDettaglioBack(){
    this.dettaglioVisible=false;
  }

}
