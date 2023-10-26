import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { RegistroListaComponent } from './registro-lista.component';
import { CommonModule } from '@angular/common';



@NgModule({
	imports: [RouterModule.forChild([
		{ path: '', component: RegistroListaComponent }
	])],
	exports: [RouterModule]
})
export class registroListaModule { }
