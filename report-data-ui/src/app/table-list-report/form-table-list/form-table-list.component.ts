import { Component, OnInit } from '@angular/core';
import { Venda } from 'src/app/shared/entity/venda';
import { VendaService } from './../../shared/service/venda.service';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-form-table-list',
  templateUrl: './form-table-list.component.html',
  styleUrls: ['./form-table-list.component.css']
})
export class FormTableListComponent implements OnInit {

  venda: any
  vendas: Venda[] = []

  filteredCountriesSingle: any[]

  constructor(private vendaService: VendaService) { }

  ngOnInit() {       
  }

  filterCountrySingle(event) {
    let query = event.query;
    this.vendaService.getVendas().subscribe(countries => {
        this.filteredCountriesSingle = this.filterCountry(query, countries);
    });
  }

  filterCountry(query, countries: any[]):any[] {
    let filtered : any[] = [];
    for(let i = 0; i < countries.length; i++) {
        let country = countries[i];
        if(country.nomeLoja.toLowerCase().indexOf(query.toLowerCase()) == 0) {
            filtered.push(country);
        }
    }
    return filtered;
}

  adicionar(form: FormControl){
    return this.vendaService.postVenda(form.value)
      .subscribe(venda => {
        this.vendas = venda
        form.reset()
      })
  }


}
