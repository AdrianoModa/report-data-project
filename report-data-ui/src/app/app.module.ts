import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TableListReportComponent } from './table-list-report/table-list-report.component';

import {TableModule} from 'primeng/table';
import {InputTextModule} from 'primeng/inputtext';
import {InputMaskModule} from 'primeng/inputmask';
import {ToastModule} from 'primeng/toast';
import {ButtonModule} from 'primeng/button';
import {AutoCompleteModule} from 'primeng/autocomplete';
import {DropdownModule} from 'primeng/dropdown';
import {CalendarModule} from 'primeng/calendar';
import {PanelModule} from 'primeng/panel';
import {ContextMenuModule} from 'primeng/contextmenu';

import { CurrencyMaskModule } from 'ng2-currency-mask';

import { VendaService } from './shared/service/venda.service';
import { LojaService } from './shared/service/loja.service';
import { HttpClientModule } from '@angular/common/http';
import { FormTableListComponent } from './table-list-report/form-table-list/form-table-list.component';
import { NavbarComponent } from './navbar/navbar.component';

@NgModule({
  declarations: [
    AppComponent,
    TableListReportComponent,
    FormTableListComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    TableModule,
    InputTextModule,
    InputMaskModule,
    ToastModule,
    ButtonModule,
    AutoCompleteModule,
    DropdownModule,
    CalendarModule,
    PanelModule,
    CurrencyMaskModule,
    ContextMenuModule
  ],
  providers: [VendaService, LojaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
