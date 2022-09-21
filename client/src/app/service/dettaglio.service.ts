import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DettagliListResponse } from '../model/DettagliListResponse';
import { Dettaglio } from '../model/Dettaglio';

@Injectable({
  providedIn: 'root'
})
export class DettaglioService {

  baseUrl="http://localhost:8080/api"

  constructor(private httpClient: HttpClient) { }

  save(dettaglio: Dettaglio,fatturaId: number) : Observable<Dettaglio>{
    return this.httpClient.post<Dettaglio>(this.baseUrl+"/dettaglio/",{
      fatturaId: fatturaId,
      dettaglioDto: dettaglio
    })
  }

  delete(dettaglio: Dettaglio): Observable<void>{
    return this.httpClient.delete<void>(this.baseUrl + "/dettaglio/"+dettaglio.id);
   }

  saveAll(dettagli: Array<Dettaglio>,fatturaId: number): Observable<void>{
     return this.httpClient.post<void>(this.baseUrl+"/dettaglio/all",{
      fatturaId: fatturaId,
      dettagli: dettagli
     });
   }

   getAll(fatturaId: number): Observable<DettagliListResponse>{
     return this.httpClient.get<DettagliListResponse>(this.baseUrl+"/dettaglio/"+fatturaId);
   }
}
