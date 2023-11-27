import { Component, ElementRef, ViewChild } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { LayoutService } from "./service/app.layout.service";
<<<<<<< HEAD
import { Router } from '@angular/router';
import { DialogService } from 'primeng/dynamicdialog';
import { DialogModule } from 'primeng/dialog';
=======
import { AuthService } from '@auth0/auth0-angular';

>>>>>>> 092996c1c9e6c2b625989842b5dea6a44d96505c
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

<<<<<<< HEAD
    constructor(public layoutService: LayoutService, private Router:Router,private dialogService: DialogService, ) { }
=======
    constructor(public layoutService: LayoutService, public auth: AuthService) { }

    logOut(){
        this.auth.logout()
    }
>>>>>>> 092996c1c9e6c2b625989842b5dea6a44d96505c
}
