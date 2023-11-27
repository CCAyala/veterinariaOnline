import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { PlanMejoramientoComponent } from './plan-mejoramiento.component';
import { CommonModule } from '@angular/common';
import { medicamentos } from 'src/app/demo/module/medicamentos';


@NgModule({
	imports: [RouterModule.forChild([
		{ path: '', component: PlanMejoramientoComponent }
	])],
	exports: [RouterModule]
})
export class perfilModule { }