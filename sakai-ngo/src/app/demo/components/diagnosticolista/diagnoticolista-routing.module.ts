import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { DiagnosticolistaComponent } from './diagnosticolista.component';
import { CommonModule } from '@angular/common';
import { medicamentos } from 'src/app/demo/module/medicamentos';


@NgModule({
	imports: [RouterModule.forChild([
		{ path: '', component: DiagnosticolistaComponent }
	])],
	exports: [RouterModule]
})
export class diagnosticolistaModule { }