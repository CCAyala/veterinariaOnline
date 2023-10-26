import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AnalisisComponent } from './analisis.component';
import { CommonModule } from '@angular/common';



@NgModule({
	imports: [RouterModule.forChild([
		{ path: '', component: AnalisisComponent }
	])],
	exports: [RouterModule]
})
export class analisisModule { }
