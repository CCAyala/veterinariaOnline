import { Component, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-selector',
  templateUrl: './selector.component.html',
  styleUrls: ['./selector.component.scss']
})
export class SelectorComponent {
  @Output() opcionSeleccionada = new EventEmitter<string>();

  seleccionarOpcion(opcion: string) {
    this.opcionSeleccionada.emit(opcion);
  }

}
