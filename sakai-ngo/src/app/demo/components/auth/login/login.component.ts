import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '@auth0/auth0-angular';
import { LayoutService } from 'src/app/layout/service/app.layout.service';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styles: [`
        :host ::ng-deep .pi-eye,
        :host ::ng-deep .pi-eye-slash {
            transform:scale(1.6);
            margin-right: 1rem;
            color: var(--primary-color) !important;
        }
    `]
})
export class LoginComponent {

    valCheck: string[] = ['remember'];

    password!: string;

    constructor(public layoutService: LayoutService,public auth: AuthService, private router: Router) { }
    ngOnInit():void{
        this.auth.isAuthenticated$.subscribe(isAuthenticaed =>{
            if(isAuthenticaed){ 
                this.router.navigate(['/dashboard'])
            }
        })
    }

    login(){
        this.auth.loginWithRedirect()
    }
}
