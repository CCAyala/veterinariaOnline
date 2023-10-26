import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { Messages } from 'primeng/messages';
import { diagnostico } from '../../module/diagnostico';
import { DiagnosticoService } from '../../service/diagnostico.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DialogService } from 'primeng/dynamicdialog';
@Component({
  selector: 'app-diagnosticolista',
  templateUrl: './diagnosticolista.component.html',
  styleUrls: ['./diagnosticolista.component.scss']
})
export class DiagnosticolistaComponent implements OnInit{

  searchText = '';
  mensajeError='';
  mostrarRealiza = true;
  items: MenuItem[];
  visible: boolean = false;
  itemss: MenuItem[] | undefined;
cols: any;
messages: Messages[]=[];
  loading: boolean = false;
  mensajeExito: string;
  modoEdicion = false; // Inicialmente, no estamos en modo edición
  location: any;
  visibleCreacion: boolean = false;
  visibleEdicion: boolean = false;
  Diagnostico : diagnostico[]=[];
  DiagnosticoForm: FormGroup
  diagnost: diagnostico[];
  diagnosticoSeleccionado :diagnostico;

constructor( private dialogService: DialogService,
  private fb: FormBuilder, private DiagnosticoService: DiagnosticoService){
    this.DiagnosticoForm=this.fb.group({
      nDiagnostico:['',Validators.required],
      
      estado:['',Validators.required],
      descripccion:['',Validators.required]
    });
  }

  ngOnInit(): void {
    this.itemss = [
      { label: 'Inicio', icon: 'pi pi-fw pi-home', routerLink:['/'] },
      { label: 'Nuevo Registro', icon: 'pi pi-fw pi-calendar',routerLink: ['/registros'] },
     
  ];

  this.loadReady();

  this.cols=[
    {field:"nDiagnostico", header:"N° diagnostico"},
    {field:"nombre", header:"Nombre Mascota"},
    {field:"estado", header:"Estado de la Mascota"},
    {field:"descripccion", header:"Descripcion"}
  ]
  }

  loadReady(){

    this.DiagnosticoService.obtenerDiagnosticos().subscribe(
      (response : diagnostico[])=>{
        let Diagn : diagnostico[]=[];
        for(let i =0; i < response.length; i++){
          let diagnos= response[i] as diagnostico;
        Diagn.push(diagnos);
        }
        this.Diagnostico= Diagn;
        console.log("que sale " + response);
      },(error) => {
        console.error('Error al cargar los Diagnostico', error);
        this.mensajeError = 'Error al cargar los Diagnostico.';
      }
      );
  }

  showDialog(){
    this.visible = true;
  }

  abrirModal(diagnostico : diagnostico){
    this.diagnosticoSeleccionado=diagnostico;
    this.DiagnosticoForm.setValue({
      nDiagnostico : diagnostico.nDiagnostico,
      estado:diagnostico.estado,
      descripccion:diagnostico.descripccion
    });

    this.visibleEdicion = true;
  }


  guardarCambios(){
    this.diagnosticoSeleccionado.nDiagnostico=this.DiagnosticoForm.value.nDiagnostico;
    this.diagnosticoSeleccionado.estado=this.DiagnosticoForm.value.estado;
    this.diagnosticoSeleccionado.descripccion=this.DiagnosticoForm.value.descripccion

    this.DiagnosticoService.actualizarDiagnostico(this.diagnosticoSeleccionado.nDiagnostico,this.diagnosticoSeleccionado).subscribe
    ((resutltado)=>{
      console.log('Diagnostico actualizado con éxito:', resutltado);
    this.visible = false;
    this.visibleEdicion=false;
  },
  (error) => {
    console.error('Error al actualizar el Diagnostico', error);
    // Manejo de errores
   } );

  }

}
