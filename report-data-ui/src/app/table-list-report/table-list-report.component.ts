import { Component, OnInit } from '@angular/core';
import { Venda } from './../shared/entity/venda';
import { VendaService } from './../shared/service/venda.service';
import { validateConfig } from '@angular/router/src/config';

@Component({
  selector: 'app-table-list-report',
  templateUrl: './table-list-report.component.html',
  styleUrls: ['./table-list-report.component.css']
})
export class TableListReportComponent implements OnInit {

  mesInput: string[]
  vendas: Venda[] = []
  valorData: number
  mouth: Venda
  meses = 
  [
    {
      nome: 'Janeiro',
      value: '01'
    },
    {
      nome: 'Fevereiro',
      value: '02'
    },
    {
      nome: 'Março',
      value: '03'
    },
    {    
      nome: 'Abril',
      value: '04'
    },
    {
      nome: 'Maio',
      value: '05'
    },
    {
      nome: 'Junho',
      value: '06'
    },
    {
      nome: 'Julho',
      value: '07'
    },
    {
      nome: 'Agosto',
      value: '08'
    },
    {    
      nome: 'Setembro',
      value: '09'
    },
    {
      nome: 'Outubro',
      value: '10'
    
    },
    {
      nome: 'Novembro',
      value: '11'
    },
    {    
      nome: 'Dezembro',
      value: '12'
    }
  ]

  constructor(private vendaService: VendaService) { }

  ngOnInit() {
    this.listarVendas()
  }

  listarVendas(){
    this.vendaService.getVendas()
      .subscribe(venda => this.vendas = venda)
  }

  listarVendasPorMes(mes: number){
    this.vendaService.getVendasPorMes(mes)
      .subscribe(venda => this.vendas = venda)
  }

  listaMesAnterior(mes: number){
    this.vendaService.getVendasPorMes(mes)
      .subscribe(() => {
        let mesPassado = this.vendas.map(res => res.data)
        this.mesInput = mesPassado
      })
  }

}
