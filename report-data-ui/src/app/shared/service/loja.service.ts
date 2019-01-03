import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Loja } from '../entity/loja';

@Injectable()
export class VendaService {

    constructor(private http: HttpClient){}

    urlLoja = 'http://localhost:8080/loja'

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