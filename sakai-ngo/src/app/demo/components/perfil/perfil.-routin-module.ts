import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { PerfilComponent } from './perfil.component';
import { CommonModule } from '@angular/common';
import { medicamentos } from 'src/app/demo/module/medicamentos';


@NgModule({
	imports: [RouterModule.forChild([
		{ path: '', component: PerfilComponent }
	])],
	exports: [RouterModule]
})
export class perfilModule { }
