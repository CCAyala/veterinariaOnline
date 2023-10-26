import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { DiagnosticoComponent } from './diagnostico.component';
import { CommonModule } from '@angular/common';
import { medicamentos } from 'src/app/demo/module/medicamentos';


@NgModule({
	imports: [RouterModule.forChild([
		{ path: '', component: DiagnosticoComponent }
	])],
	exports: [RouterModule]
})
export class diagnosticoModule { }
