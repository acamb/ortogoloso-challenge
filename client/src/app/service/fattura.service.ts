import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Fattura } from '../model/Fattura';

@Injectable({
  providedIn: 'root'
})
export class FatturaService {

  baseUrl = "http://localhost:8080/api"

  constructor(private httpClient: HttpClient) { }

  get(id: number): Observable<Fattura>{
    return this.httpClient.get<Fattura>(this.baseUrl+"/fattura/"+id);
  }

  getAll(): Observable<Array<Fattura>>{
    return this.httpClient.get<Array<Fattura>>(this.baseUrl+"/fattura/all");
  }

  save(fattura: Fattura): Observable<Fattura>{
    return this.httpClient.post<Fattura>(this.baseUrl+"/fattura/",fattura);
  }

  delete(fattura: Fattura): Observable<void>{
    return this.httpClient.delete<void>(this.baseUrl+"/fattura/"+fattura.id);
  }
}
