import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Venda } from 'src/app/shared/entity/venda';
import { VendaService } from './../../shared/service/venda.service';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-form-table-list',
  templateUrl: './form-table-list.component.html',
  styleUrls: ['./form-table-list.component.css']
})
export class FormTableListComponent implements OnInit {

  venda: Venda
  vendas: Venda[] = []
  filteredCountriesSingle: any[]
  @Output() vendaSalva = new EventEmitter()
  @Output() calculoNovo = new EventEmitter()
  lojas: Array<any> = [ 'PTOMAD', 'MATRIZ']
    
    // { nome: "JULIOLIM"},{ nome: "OLPAIVA"},{ nome: "OSOPAIVA"},{ nome: "VVELHA,"},{ nome: "VTAVORA"},
    // { nome: "JWALTER"},{ nome: "CBRANCO"},{ nome: "JPENHA"},{ nome: "JQMFELIC"},{ nome: "JOSELEON"},{ nome: "ASALES"},{ nome: "TREZMAIO"},
    // { nome: "SERRINHA"},{ nome: "MARACANAU"},{ nome: "FRCIRILO"},{ nome: "WALDIOGO"},{ nome: "JOCARLOS"},{ nome: "MDOURADO"},{ nome: "HJORGE"},
    // { nome: "SIQUEIRA"}    

  constructor(private vendaService: VendaService) { }

  ngOnInit() {
    this.listarVendas()   
  }

  listarVendas(){
    this.vendaService.getVendas()
      .subscribe(venda => this.vendas = venda)
  }

  filterCountrySingle(event) {
    let query = event.query
    this.vendaService.getVendas().subscribe(countries => {
        this.filteredCountriesSingle = this.filterCountry(query, countries)
    })
  }

  filterCountry(query, countries: any[]):string[] {
    let filtered : any[] = [];
    for(let i = 0; i < countries.length; i++) {
      let country = countries[i];
      if(country.nomeLoja.toLowerCase().indexOf(query.toLowerCase()) == 0) {
        filtered.push(country)
      }
    }
  return filtered
}

  adicionar(form: FormControl) {
    return this.vendaService.postVenda(form.value)
      .subscribe(venda => {
        this.vendas = venda
        form.reset()
        this.vendaSalva.emit(venda)
        this.calculoNovo.emit(venda)
      })
  }


}
