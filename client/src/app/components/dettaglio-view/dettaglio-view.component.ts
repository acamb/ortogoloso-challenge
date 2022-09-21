import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Dettaglio } from 'src/app/model/Dettaglio';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
/**
 * Componente per l'inserimento di un nuovo dettaglio
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


  constructor() {
      
   }

  ngOnInit(): void {
  }

  onSubmit(form: NgForm){
    if(form.valid){
        this.save.emit(this.dettaglio);
        this.dettaglio=new Dettaglio();
    }
  }

  onBack(){
      this.back.emit();
      this.dettaglio=new Dettaglio();
  }

}
