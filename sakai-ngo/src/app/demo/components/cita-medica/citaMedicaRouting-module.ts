import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CitaMedicaComponent } from './cita-medica.component';
import { CommonModule } from '@angular/common';



@NgModule({
	imports: [RouterModule.forChild([
		{ path: '', component: CitaMedicaComponent }
	])],
	exports: [RouterModule]
})
export class citaMedicaModule { }
