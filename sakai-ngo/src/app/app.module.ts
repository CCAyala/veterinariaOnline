import { NgModule } from '@angular/core';
import { HashLocationStrategy, LocationStrategy } from '@angular/common';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { AppLayoutModule } from './layout/app.layout.module';
import { NotfoundComponent } from './demo/components/notfound/notfound.component';
import { ProductService } from './demo/service/product.service';
import { CountryService } from './demo/service/country.service';
import { CustomerService } from './demo/service/customer.service';
import { EventService } from './demo/service/event.service';
import { IconService } from './demo/service/icon.service';
import { NodeService } from './demo/service/node.service';
import { PhotoService } from './demo/service/photo.service';
import { MedicamentosComponent } from './demo/components/medicamentos/medicamentos.component';
import { TableModule } from 'primeng/table';
import { BrowserModule } from '@angular/platform-browser';
import { PagesRoutingModule } from './demo/components/pages/pages-routing.module';
 import { MedicamentosService } from './demo/service/medicamentos.service';
 import { ButtonModule } from 'primeng/button';
 import { DialogModule } from 'primeng/dialog';
 import { DialogService } from 'primeng/dynamicdialog';
 import { ReactiveFormsModule } from '@angular/forms';
import { RegistroComponent } from './demo/components/registro/registro.component';
import { MascotasComponent } from './demo/components/mascotas/mascotas.component';
import { FormsModule } from '@angular/forms';
import { InputTextModule } from 'primeng/inputtext';
import { TabMenuModule } from 'primeng/tabmenu';
import { MessagesModule } from 'primeng/messages';
import { CalendarModule } from 'primeng/calendar';
import { AnalisisComponent } from './demo/components/analisis/analisis.component';
import { RegistroListaComponent } from './demo/components/registro-lista/registro-lista.component';
import{PanelModule } from 'primeng/panel'
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MessageModule } from 'primeng/message';
import { FieldsetModule } from 'primeng/fieldset';
import { TooltipModule } from 'primeng/tooltip';
import { InputTextareaModule } from 'primeng/inputtextarea';
import { AnalisislistaComponent } from './demo/components/analisislista/analisislista.component';
import { DiagnosticoComponent } from './demo/components/diagnostico/diagnostico.component';
import { SplitterModule } from 'primeng/splitter';
import { DiagnosticolistaComponent } from './demo/components/diagnosticolista/diagnosticolista.component';
import { CarouselModule } from 'primeng/carousel';
@NgModule({
    declarations: [
        AppComponent, NotfoundComponent, MedicamentosComponent, RegistroComponent, MascotasComponent, AnalisisComponent, RegistroListaComponent, AnalisislistaComponent, DiagnosticoComponent, DiagnosticolistaComponent
    ],
    imports: [
        AppRoutingModule,
        AppLayoutModule,
        TableModule,
        BrowserModule,
        PagesRoutingModule,
        ButtonModule,
        DialogModule,
        ReactiveFormsModule,FormsModule,InputTextModule,
        MessagesModule,
        TabMenuModule,
        CalendarModule,
        PanelModule,
        BrowserAnimationsModule, MessageModule,FieldsetModule,TooltipModule,
        InputTextareaModule,SplitterModule,CarouselModule
    ],
    providers: [
        { provide: LocationStrategy, useClass: HashLocationStrategy },
        CountryService, CustomerService, EventService, IconService, NodeService,
        PhotoService, ProductService, DialogService
    ],
    bootstrap: [AppComponent]
})
export class AppModule { }
