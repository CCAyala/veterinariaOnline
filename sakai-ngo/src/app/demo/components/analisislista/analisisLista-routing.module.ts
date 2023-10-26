import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { medicamentos } from 'src/app/demo/module/medicamentos';
import { AnalisislistaComponent } from './analisislista.component';



@NgModule({
	imports: [RouterModule.forChild([
		{ path: '', component: AnalisislistaComponent }
	])],
	exports: [RouterModule]
})
export class AnalisislistaModule { }
