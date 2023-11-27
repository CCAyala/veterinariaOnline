import { Component } from '@angular/core';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.scss']
})
export class PerfilComponent {

name = 'Cristian ayala';
following = 5001;
followers = 10002;

strengths = [{ text: 'cedula', level: '1073242770' }, { text: 'Ocupacion', level: 'estudiantte' }, { text: 'Telefono', level: '3025215775' }];

people = [
  {
    "name": "Vanessa M.",
    "age": 16,
    "color": 'red'
  },
  {
    "name": "Carlos Angulo",
    "age": 25,
    "color": 'green'
  },
 
];
}
