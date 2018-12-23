import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Venda } from './../entity/venda';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VendaService {

  urlVenda = 'http://localhost:8080/venda'

  constructor(private http: HttpClient) { }

  getVendas(): Observable<any> {
    return this.http.get<any>(`${this.urlVenda}`)
  }

  getVendasData(data: any): Observable<any> {
    return this.http.get<any>(`${this.urlVenda}/data/${data}`)
  }

  postVenda(venda: Venda): Observable<any> {
    return this.http.post(`${this.urlVenda}`, venda)
  }

}
