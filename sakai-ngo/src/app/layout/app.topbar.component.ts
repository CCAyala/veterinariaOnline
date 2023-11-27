import { Component, ElementRef, ViewChild } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { LayoutService } from "./service/app.layout.service";
import { Router } from '@angular/router';
import { DialogService } from 'primeng/dynamicdialog';
import { DialogModule } from 'primeng/dialog';
@Component({
    selector: 'app-topbar',
    templateUrl: './app.topbar.component.html',
    styleUrls: ['./app.topbar.component.scss']
    
})
export class AppTopBarComponent {
    mostrarSubMenu = false;

    seleccionarOpcion(opcion: string) {
        // Lógica para manejar la opción seleccionada
        console.log('Opción seleccionada:', opcion);
        this.mostrarSubMenu = false;
        this.Router.navigate([opcion]); // Ocultar el submenú después de seleccionar
    }
    items!: MenuItem[];

    @ViewChild('menubutton') menuButton!: ElementRef;

    @ViewChild('topbarmenubutton') topbarMenuButton!: ElementRef;

    @ViewChild('topbarmenu') menu!: ElementRef;

    constructor(public layoutService: LayoutService, private Router:Router,private dialogService: DialogService, ) { }
}
