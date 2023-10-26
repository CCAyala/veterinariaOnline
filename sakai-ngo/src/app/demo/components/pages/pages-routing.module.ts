import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { MedicamentosService } from '../../service/medicamentos.service';
import { medicamentos } from '../../module/medicamentos';
import { MedicamentosComponent } from '../medicamentos/medicamentos.component';

@NgModule({
    imports: [RouterModule.forChild([
        
      
        { path: '**', redirectTo: '/medicamentos' },
        {path: 'medicamentos',component: MedicamentosComponent},
        { path: 'medicamento', data: { breadcrumb: 'medicamento' }, loadChildren: () => import('../medicamentos/medicamentos-routing.modules').then(m => m.MedicamentosModule) },


       
    ])],
    exports: [RouterModule]
})
export class PagesRoutingModule { }
