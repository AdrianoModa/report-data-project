import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TableListReportComponent } from './table-list-report/table-list-report.component';

import {TableModule} from 'primeng/table';

import { VendaService } from './shared/service/venda.service';
import { HttpClientModule } from '@angular/common/http';
import { FormTableListComponent } from './table-list-report/form-table-list/form-table-list.component';

@NgModule({
  declarations: [
    AppComponent,
    TableListReportComponent,
    FormTableListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    TableModule
  ],
  providers: [VendaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
