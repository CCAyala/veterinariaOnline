import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { RegistroComponent } from './registro.component';
import { CommonModule } from '@angular/common';



@NgModule({
	imports: [RouterModule.forChild([
		{ path: '', component: RegistroComponent }
	])],
	exports: [RouterModule]
})
export class registroModule { }
