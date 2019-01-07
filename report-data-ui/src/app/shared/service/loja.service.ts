import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Loja } from '../entity/loja';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
  })
export class LojaService {    

    urlLoja = 'http://localhost:8080/loja'

    constructor(private http: HttpClient){}

    getLojas(): Observable<any> {
        return this.http.get<any>(`${this.urlLoja}`)
    }

    getLojaPorId(id: number): Observable<any> {
        return this.http.get<any>(`${this.urlLoja}/${id}`)
    }

    postLoja(loja: Loja): Observable<any> {
        return this.http.post(`${this.urlLoja}`, loja)
    }

    putLoja(loja: Loja): Observable<any> {
        return this.http.put(`${this.urlLoja}/${loja.id}`, loja)
    }

    deleteLoja(id: number): Observable<any> {
        return this.http.delete(`${this.urlLoja}/${id}`)
    }

}