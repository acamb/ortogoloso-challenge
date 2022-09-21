import { Component, OnInit } from '@angular/core';

/**
 * Componente che elenca le fatture ed orchestra il routing verso il dettaglio e le operazioni sulle fatture
 */
@Component({
  selector: 'app-fatture-list',
  templateUrl: './fatture-list.component.html',
  styleUrls: ['./fatture-list.component.css']
})
export class FattureListComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
