import { RouterModule, Routes } from '@angular/router';
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
import { LoginComponent } from './demo/components/auth/login/login.component';

const routes: Routes=[

    {
        path: '',
        pathMatch: 'full',
        redirectTo: 'dashboard',
    },
    {path : 'login',
     component: LoginComponent},
    {
        path: '',
        loadChildren: ()=>
        import('./demo/components/dashboard/dashboard.module').then(m => m.DashboardModule),
    }

]
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
                    {path: 'diagnosticolist', loadChildren:()=> import('./demo/components/diagnosticolista/diagnoticolista-routing.module').then(m =>m.diagnosticolistaModule)}
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
            {path:'diagnosticolist', component: DiagnosticolistaComponent}
        ], { scrollPositionRestoration: 'enabled', anchorScrolling: 'enabled', onSameUrlNavigation: 'reload' })
    ],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
