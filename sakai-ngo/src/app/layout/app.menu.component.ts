import { OnInit } from '@angular/core';
import { Component } from '@angular/core';
import { LayoutService } from './service/app.layout.service';

@Component({
    selector: 'app-menu',
    templateUrl: './app.menu.component.html'
})
export class AppMenuComponent implements OnInit {

    model: any[] = [];

    constructor(public layoutService: LayoutService) { }

    ngOnInit() {
        this.model = [
            {
                label: 'Home',
                items: [
                    { label: 'Inicio', icon: 'pi pi-fw pi-home', routerLink: ['/'] },
                    
                ]
            },
            {

                label: 'Listas',
                icon: 'pi pi-fw pi-book',
                items: [
                   
                    {
                        label: 'buscar Listas',
                        icon: 'pi pi-fw pi-list',
                        items:
                         [
                            {
                                label:'Registros',
                                icon:'pi pi-fw pi-book',
                                routerLink: ['/registroLista']
                            },
                            {
                                label: 'Analisis',
                                icon: 'pi pi-fw pi-language',
                                routerLink: ['/analisisLista']
                            },
                            {
                                label: 'Diagnostico',
                                icon: 'pi pi-fw pi-language',
                                routerLink: ['/diagnosticolist']
                            },
                            {
                                label: 'Medicamentos',
                                icon: 'pi pi-fw pi-globe',
                                routerLink: ['/medicamentos']
                            },
                        ]
                
                    },]
            },
            
    
            {
                label: 'Consultas',
                icon: 'pi pi-fw pi-briefcase',
                items: [
                   
                    {
                        label: 'Registro de Paciente',
                        icon: 'pi pi-fw pi-file',
                        items:
                         [
                            {
                                label:'Nuevo Registro',
                                icon:'pi pi-fw pi-plus',
                                routerLink: ['/registros']
                            }
                        ]
                    
                    },
                   
                    {
                        label: 'Auth',
                        icon: 'pi pi-fw pi-user',
                        items: [
                            {
                                label: 'Login',
                                icon: 'pi pi-fw pi-sign-in',
                                routerLink: ['/auth/login']
                            },
                            {
                                label: 'Error',
                                icon: 'pi pi-fw pi-times-circle',
                                routerLink: ['/auth/error']
                            },
                            {
                                label: 'Access Denied',
                                icon: 'pi pi-fw pi-lock',
                                routerLink: ['/auth/access']
                            }
                        ]
                    },
                   
                    {
                        label: 'Not Found',
                        icon: 'pi pi-fw pi-exclamation-circle',
                        routerLink: ['/medicamentos']
                    },

                   
                   
                ]
            },

            
            {
                label: 'Servicios',
                items: [
                    {
                        label: 'Submenu 1', icon: 'pi pi-fw pi-bookmark',
                        items: [
                            {
                                label: 'Submenu 1.1', icon: 'pi pi-fw pi-bookmark',
                                items: [
                                    { label: 'Submenu 1.1.1', icon: 'pi pi-fw pi-bookmark' },
                                    { label: 'Submenu 1.1.2', icon: 'pi pi-fw pi-bookmark' },
                                    { label: 'Submenu 1.1.3', icon: 'pi pi-fw pi-bookmark' },
                                ]
                            },
                            {
                                label: 'Submenu 1.2', icon: 'pi pi-fw pi-bookmark',
                                items: [
                                    { label: 'Submenu 1.2.1', icon: 'pi pi-fw pi-bookmark' }
                                ]
                            },
                        ]
                    },
                    {
                        label: 'Submenu 2', icon: 'pi pi-fw pi-bookmark',
                        items: [
                            {
                                label: 'Submenu 2.1', icon: 'pi pi-fw pi-bookmark',
                                items: [
                                    { label: 'Submenu 2.1.1', icon: 'pi pi-fw pi-bookmark' },
                                    { label: 'Submenu 2.1.2', icon: 'pi pi-fw pi-bookmark' },
                                ]
                            },
                            {
                                label: 'Submenu 2.2', icon: 'pi pi-fw pi-bookmark',
                                items: [
                                    { label: 'Submenu 2.2.1', icon: 'pi pi-fw pi-bookmark' },
                                ]
                            },
                        ]
                    }
                ]
            },
            
        ];
    }
}
