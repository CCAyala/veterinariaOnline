import { Component,OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators,FormControl } from '@angular/forms';
import { PrimeIcons, MenuItem } from 'primeng/api';
import { Messages } from 'primeng/messages';
import { registro } from '../../module/registro';
import { RealizaService } from '../../service/registro.service';
import { DialogService } from 'primeng/dynamicdialog';



@Component({
  selector: 'app-registro-lista',
  templateUrl: './registro-lista.component.html',
  styleUrls: ['./registro-lista.component.scss']
})
export class RegistroListaComponent implements OnInit{
  itemss: MenuItem[] | undefined;
  items: MenuItem[];
  visible: boolean = false;
  visibleEdicion: boolean=false;
 realiza : registro[]=[];
 realizaform:FormGroup;
 realizaSeleccionado: registro;
 searchText = '';
 mensajeError='';
 loading: boolean = false;
  constructor(private RealizaService : RealizaService,
    private dialogService: DialogService,
    private fb: FormBuilder
    ){
   this.realizaform=this.fb.group({
    codRegistro:['',Validators.required],
    estadoRespiratorio:['',Validators.required],
    estadoCardioMuscular:['',Validators.required],
    estadoDigestivo:['',Validators.required],
    estadoGenitario:['',Validators.required],
    estadoSistemaNervioso:['',Validators.required],
    estadomMusculoEsqueletico:['',Validators.required],
    fechaIngreso:['',Validators.required],
    estadoOjos:['',Validators.required],
    estadoPiel:['',Validators.required],
    estadoModuloslinfaticos:['',Validators.required],
    estadoLocomocion:['',Validators.required]
   })
    }

  ngOnInit(): void {
      this.itemss = [
      { label: 'Inicio', icon: 'pi pi-fw pi-home', routerLink:['/'] },
      { label: 'Analisis', icon: 'pi pi-fw pi-calendar',routerLink: ['/registros'] },
     
  ];

  this.items = [
    {
        label: 'New',
        icon: PrimeIcons.PLUS,
        command: () => this.showDialog(),
    },
  ],
  this.loadRealiza();
}
showDialog(){
  this.visible = true;
}

loadRealiza(){
  this.RealizaService.getRegistros().subscribe
  ((response : registro[])=>{
    this.realiza=response;
    console.log("que sale " + response);
  },(error) => {
    console.error('Error al cargar medicamentos', error);
    this.mensajeError = 'Error al cargar los medicamentos.';
  }
  );
  }

  abrirModal(realiza: registro) {
    // Inicializa el formulario con los datos del medicamento seleccionado
    this.realizaSeleccionado = realiza;
    this.realizaform.setValue({
      codRegistro:realiza.codRegistro,
      estadoRespiratorio:realiza.estadoRespiratorio,
      estadoCardioMuscular:realiza.estadoCardioMuscular,
      estadoDigestivo: realiza.estadoDigestivo,
      estadoGenitario:realiza.estadoGenitario,
      estadoSistemaNervioso:realiza.estadoSistemaNervioso,
      estadomMusculoEsqueletico:realiza.estadomMusculoEsqueletico,
      fechaIngreso:realiza.fechaIng,
      estadoOjos:realiza.estadoOjos,
      estadoPiel:realiza.estadoPielyanex,
      estadoModuloslinfaticos:realiza.estadoModuloslinfaticos,
      estadoLocomocion:realiza.estadoLocomocion,
    });

    this.visibleEdicion = true;
  }

  guardarCambios() {
    // Actualiza los datos del medicamento seleccionado con los valores del formulario

    this.realizaSeleccionado.codRegistro=this.realizaform.value.codRegistro;
    this.realizaSeleccionado.estadoCardioMuscular=this.realizaform.value.estadoCardioMuscular;
    this.realizaSeleccionado.estadoDigestivo=this.realizaform.value.estadoDigestivo;
    this.realizaSeleccionado.estadoGenitario=this.realizaform.value.estadoGenitario;
    this.realizaSeleccionado.estadoLocomocion=this.realizaform.value.estadoLocomocion;
    this.realizaSeleccionado.estadoModuloslinfaticos=this.realizaform.value.estadoModuloslinfaticos;
    this.realizaSeleccionado.estadoOjos=this.realizaform.value.estadoOjos;
    this.realizaSeleccionado.estadoPielyanex=this.realizaform.value.estadoPiel;
    this.realizaSeleccionado.estadoSistemaNervioso=this.realizaform.value.estadoSistemaNervioso;
    this.realizaSeleccionado.estadoRespiratorio=this.realizaform.value.estadoRespiratorio;
    this.realizaSeleccionado.estadomMusculoEsqueletico=this.realizaform.value.estadomMusculoEsqueletico;
    this.realizaSeleccionado.fechaIng=this.realizaform.value.fechaIngreso;

    this.RealizaService.actualizarRegistro(this.realizaSeleccionado.codRegistro,
      this.realizaSeleccionado).subscribe(
      (resultado) => {
        console.log('Medicamento actualizado con éxito:', resultado);
        this.visible = false;
        this.visibleEdicion=false;
      },
      (error) => {
        console.error('Error al actualizar el medicamento:', error);
        // Manejo de errores
      }
    );
  }


}
