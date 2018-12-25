import { Component, OnInit } from '@angular/core';
import { Venda } from './../shared/entity/venda';
import { VendaService } from './../shared/service/venda.service';

@Component({
  selector: 'app-table-list-report',
  templateUrl: './table-list-report.component.html',
  styleUrls: ['./table-list-report.component.css']
})
export class TableListReportComponent implements OnInit {

  vendas: Venda[] = []
  valorNovembro: number[];

  constructor(private vendaService: VendaService) { }

  ngOnInit() {
    this.listarVendas()
    // this.listarVendasPorMes(10)
    this.listarNovembro(10)
  }

  listarNovembro(mes: number){
    this.vendaService.getVendas()
      .subscribe(venda => {
        let valor = this.vendas.map(res => res.dia)
        this.valorNovembro = valor
        console.log(this.valorNovembro)
      })
  }

  listarVendas(){
    this.vendaService.getVendas()
      .subscribe(venda => this.vendas = venda)
  }

  listarVendasPorMes(mes: number){
    this.vendaService.getVendasPorMes(mes)
      .subscribe(venda => this.vendas = venda)
  }

}
