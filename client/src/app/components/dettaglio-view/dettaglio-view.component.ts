import { Component, EventEmitter, Input, OnInit, Output, ViewChild } from '@angular/core';
import { Dettaglio } from 'src/app/model/Dettaglio';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
/**
 * Componente per l'inserimento di un nuovo dettaglio, la business logic di inserimento e' delegata al parent
 */
@Component({
  selector: 'app-dettaglio-view',
  templateUrl: './dettaglio-view.component.html',
  styleUrls: ['./dettaglio-view.component.css']
})
export class DettaglioViewComponent implements OnInit {

  dettaglio = new Dettaglio();

  @Output() save = new EventEmitter<Dettaglio>();

  @Output() back = new EventEmitter<null>();

  @Input() modalVisible=false;

  @ViewChild("dettaglioForm")
  form: NgForm;


  constructor() {
      
   }

  ngOnInit(): void {
  }

  onSubmit(form: NgForm){
    if(form.valid){
        this.save.emit(this.dettaglio);
        
        //Visto che riutilizzo la modal facendola apparire/scomparire, devo resettare la validazione ed i dati
        this.dettaglio=new Dettaglio();
        this.form.resetForm();
    }
  }

  onBack(){
      this.back.emit();

      //Visto che riutilizzo la modal facendola apparire/scomparire, devo resettare la validazione ed i dati
      this.dettaglio=new Dettaglio();
      this.form.resetForm();
  }

  /**
   * Governo la visibilita' della modal attraverso la classe css 'show'
   */
  get modalShowClass(){
    if(this.modalVisible){
      return "show";
    }
    else{
      return "";
    }
  }

  /**
   * Governo la visibilita' dello sfondo semi-trasparente impostando il valore 'display' a block/none
   */
  get modalDisplayStyle(){
    if(this.modalVisible){
      return "block";
    }
    else{
      return "none";
    }
  }

}
