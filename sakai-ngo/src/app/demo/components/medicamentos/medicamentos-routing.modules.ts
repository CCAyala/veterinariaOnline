import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { MedicamentosComponent } from './medicamentos.component';
import { CommonModule } from '@angular/common';
import { medicamentos } from 'src/app/demo/module/medicamentos';


@NgModule({
	imports: [RouterModule.forChild([
		{ path: '', component: MedicamentosComponent }
	])],
	exports: [RouterModule]
})
export class MedicamentosModule { }
