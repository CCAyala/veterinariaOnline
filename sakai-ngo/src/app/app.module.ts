import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
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
<<<<<<< HEAD
import { PerfilComponent } from './demo/components/perfil/perfil.component';
import { FullCalendarModule } from '@fullcalendar/angular';
import { CitaMedicaComponent } from './demo/components/cita-medica/cita-medica.component';
import { SelectorComponent } from './demo/components/auth/selector/selector.component';
import { MenubarModule } from 'primeng/menubar';
import { LayoutService } from './layout/service/app.layout.service';
import { AppTopBarComponent } from './layout/app.topbar.component';
import { CheckboxModule } from 'primeng/checkbox';
import { PlanMejoramientoComponent } from './demo/components/plan-mejoramiento/plan-mejoramiento.component';



=======
// Import the module from the SDK
import { AuthModule } from '@auth0/auth0-angular';
>>>>>>> 092996c1c9e6c2b625989842b5dea6a44d96505c

@NgModule({
    declarations: [
        AppComponent, NotfoundComponent, MedicamentosComponent, RegistroComponent, MascotasComponent, AnalisisComponent, RegistroListaComponent, AnalisislistaComponent, DiagnosticoComponent, DiagnosticolistaComponent, PerfilComponent, CitaMedicaComponent, SelectorComponent, PlanMejoramientoComponent,
        
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
<<<<<<< HEAD
        InputTextareaModule,SplitterModule,CarouselModule,FullCalendarModule,
        MenubarModule,CheckboxModule
=======
        InputTextareaModule,SplitterModule,CarouselModule,
        // Import the module into the application, with configuration
    AuthModule.forRoot({
        domain: 'dev-sk2nv5ar5z2e1wr2.us.auth0.com',
        clientId: '0khPzLcieqvyRnjEfl0VH5kHoelATBqs',
        authorizationParams: {
          redirect_uri: window.location.origin
        }
      }),
>>>>>>> 092996c1c9e6c2b625989842b5dea6a44d96505c
    ],
    providers: [
        { provide: LocationStrategy, useClass: HashLocationStrategy },
        CountryService, CustomerService, EventService, IconService, NodeService,
        PhotoService, ProductService, DialogService,LayoutService
    ],
    bootstrap: [AppComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
