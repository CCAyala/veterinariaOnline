import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { NotfoundComponent } from './demo/components/notfound/notfound.component';
import { AppLayoutComponent } from "./layout/app.layout.component";
import { MedicamentosComponent } from './demo/components/medicamentos/medicamentos.component';
import { RegistroComponent } from './demo/components/registro/registro.component';
import { AnalisisComponent } from './demo/components/analisis/analisis.component';
import { RegistroListaComponent } from './demo/components/registro-lista/registro-lista.component';
import { AnalisislistaComponent } from './demo/components/analisislista/analisislista.component';
import { DiagnosticoComponent } from './demo/components/diagnostico/diagnostico.component';
import { DiagnosticolistaComponent } from './demo/components/diagnosticolista/diagnosticolista.component';
import { PerfilComponent } from './demo/components/perfil/perfil.component';
import { CitaMedicaComponent } from './demo/components/cita-medica/cita-medica.component';
import { PlanMejoramientoComponent } from './demo/components/plan-mejoramiento/plan-mejoramiento.component';

@NgModule({
    imports: [
        RouterModule.forRoot([
            {
                path: '', component: AppLayoutComponent,
                children: [
                    { path: '', loadChildren: () => import('./demo/components/dashboard/dashboard.module').then(m => m.DashboardModule) },
                    {path: 'medicamentos', loadChildren:()=> import('./demo/components/medicamentos/medicamentos-routing.modules').then(m=>m.MedicamentosModule)},
                    {path: 'registros', loadChildren: ()=> import('./demo/components/registro/registro-routing.modules').then(m => m.registroModule)},
                    { path: 'pages', loadChildren: () => import('./demo/components/pages/pages.module').then(m => m.PagesModule) },
                    {path: 'analisis/:codRegistro', loadChildren:()=> import('./demo/components/analisis/analisis-routing.module').then(m =>m.analisisModule )},
                    {path :'registroLista', loadChildren: ()=> import('./demo/components/registro-lista/registroLista-routing.module').then(m => m.registroListaModule)},
                    {path: 'analisisLista',loadChildren: ()=> import('./demo/components/analisislista/analisisLista-routing.module').then(m => m.AnalisislistaModule)},
                    {path: 'diagnostico/:codAnalisis',loadChildren:()=> import('./demo/components/diagnostico/diagnostico-routing.module').then(m =>m.diagnosticoModule)},
                    {path: 'diagnosticolist', loadChildren:()=> import('./demo/components/diagnosticolista/diagnoticolista-routing.module').then(m =>m.diagnosticolistaModule)},
                    {path: 'perfil', loadChildren:()=> import('./demo/components/perfil/perfil.-routin-module').then(m =>m.perfilModule)},
                    {path:'citaMedica',loadChildren:()=>import('./demo/components/cita-medica/citaMedicaRouting-module').then(m =>m.citaMedicaModule)},
                    {path: 'planMejoramiento', loadChildren:()=> import('./demo/components/plan-mejoramiento/planMejoramiento-routing.module').then(m =>m.perfilModule)}
                ]
            },
            { path: 'auth', loadChildren: () => import('./demo/components/auth/auth.module').then(m => m.AuthModule) },
           
            { path: 'notfound', component: NotfoundComponent },
            { path: '**', redirectTo: '/registros' },
            {path: 'medicamentos',component: MedicamentosComponent},
            {path: 'registros',component : RegistroComponent},
            {path: 'analisis/:codRegistro',component : AnalisisComponent},
            {path: 'registroLista',component: RegistroListaComponent},
            {path: 'analisisLista',component: AnalisislistaComponent},
            {path: 'diagnostico/:codAnalsis',component: DiagnosticoComponent},
            {path:'diagnosticolist', component: DiagnosticolistaComponent},
            {path: 'perfil',component: PerfilComponent},
            {path: 'citaMedica',component: CitaMedicaComponent},
            {path : 'planMejoramiento', component: PlanMejoramientoComponent}
        ], { scrollPositionRestoration: 'enabled', anchorScrolling: 'enabled', onSameUrlNavigation: 'reload' })
    ],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
