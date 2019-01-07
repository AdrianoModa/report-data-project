import { Component, OnInit, ViewChild } from '@angular/core';
import { Venda } from './../shared/entity/venda';
import { VendaService } from './../shared/service/venda.service';
import { LojaService } from '../shared/service/loja.service';
import { Loja } from '../shared/entity/loja';
import { Dropdown } from 'primeng/dropdown';

@Component({
  selector: 'app-table-list-report',
  templateUrl: './table-list-report.component.html',
  styleUrls: ['./table-list-report.component.css']
})
export class TableListReportComponent implements OnInit {

  @ViewChild('dd')
  dd: Dropdown
  vendas: Array<any>[] //Venda[] = []
  lojas: Array<any> //Loja[] = []  
  venda: any //Venda
  loja: any //Loja
  meses = 
  [
    {
      nome: 'Janeiro',
      valor: '01'
    },
    {
      nome: 'Fevereiro',
      valor: '02'
    },
    {
      nome: 'Março',
      valor: '03'
    },
    {    
      nome: 'Abril',
      valor: '04'
    },
    {
      nome: 'Maio',
      valor: '05'
    },
    {
      nome: 'Junho',
      valor: '06'
    },
    {
      nome: 'Julho',
      valor: '07'
    },
    {
      nome: 'Agosto',
      valor: '08'
    },
    {    
      nome: 'Setembro',
      valor: '09'
    },
    {
      nome: 'Outubro',
      valor: '10'
    
    },
    {
      nome: 'Novembro',
      valor: '11'
    },
    {    
      nome: 'Dezembro',
      valor: '12'
    }
  ]

  constructor(
    private vendaService: VendaService,
    private lojaService: LojaService
    ) { }

  ngOnInit() {
    this.listarVendas()
    this.listarLojas()
  }

  listarVendas(){
    return this.vendaService.getVendas()
      .subscribe(venda => this.vendas = venda)
  }

  listarLojas(){
    return this.lojaService.getLojas()
      .subscribe(loja => this.lojas = loja)
  }

  listarVendaPorLoja(nome: string){
    this.vendaService.getVendaPorLoja(nome)
      .subscribe(venda => this.vendas = venda)
      console.log(nome)
  }

  listarVendasPorMes(mes: number){
    this.vendaService.getVendasPorMes(mes)
      .subscribe(venda => this.vendas = venda)
      console.log(mes)
  }

  listarVendasPorData(data: any){
    this.vendaService.getVendasData(data)
      .subscribe(venda => this.vendas = venda)
      console.log(data)
  }

  clearFilter(){
    this.dd.selectItem(this.dd, 0)
    this.listarVendas()
  }

  resetTable(dropdown: Dropdown){
    dropdown.updateSelectedOption('')
    this.listarVendas()
  }

}
