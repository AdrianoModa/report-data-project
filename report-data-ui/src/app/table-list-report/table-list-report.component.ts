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

  constructor(private vendaService: VendaService) { }

  ngOnInit() {
    this.listarVendas()
  }

  listarVendas(){
    this.vendaService.getVendas()
      .subscribe(venda => this.vendas = venda)
  }

}
