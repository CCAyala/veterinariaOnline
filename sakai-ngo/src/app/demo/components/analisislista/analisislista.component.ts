import { Component, OnInit } from '@angular/core';
import { analisis } from '../../module/analisis';
import { DialogService } from 'primeng/dynamicdialog';
import { AnalisisService } from '../../service/analisis.service';
import { FormBuilder, FormGroup, Validators,FormControl } from '@angular/forms';
import { PrimeIcons, MenuItem } from 'primeng/api'; 
@Component({
  selector: 'app-analisislista',
  templateUrl: './analisislista.component.html',
  styleUrls: ['./analisislista.component.scss']
})
export class AnalisislistaComponent implements OnInit{
 
  itemss: MenuItem[] | undefined;
  items: MenuItem[];
  visible: boolean = false;
  visibleEdicion: boolean=false;
  analsis: analisis[];
  Analisis : analisis[]=[];
  analisisForm: FormGroup;
  analisisSeleccionado : analisis;
  searchText = '';
 mensajeError='';
  cols: any;
loading: any;
  
 
constructor(  private dialogService: DialogService,
  private fb: FormBuilder,
  private analisisService: AnalisisService){
    this.analisisForm=this.fb.group({
      codAnalisis:['',Validators.required],
      actitud:['',Validators.required],
      condicorporal:['',Validators.required],
      estadoconjutival:['',Validators.required],
      estadohidratacion:['',Validators.required],
      estadomucoso:['',Validators.required],
      oral:['',Validators.required],
      rectal:['',Validators.required],
      vulvarpropulcal:['',Validators.required],
      observaciones:['',Validators.required],
    
     });
  }

  ngOnInit(): void {
    this.itemss = [
      { label: 'Inicio', icon: 'pi pi-fw pi-home', routerLink:['/'] },
      { label: 'Nuevo Registro', icon: 'pi pi-fw pi-calendar',routerLink: ['/registros'] },
     
  ];
 
  

  this.loadReady();
  this.cols=[
    {field: "codAnalisis" ,header:"N° Analisis" },
    {field: "nombre" ,header:"Nombre mascota" },
    {field: "actitud" ,header:"Actitud" },
    {field: "condicorporal" ,header:"Condicion Corporal" },
    {field: "estadoconjutival" ,header:"Estado Conjutival" },
    {field: "estadohidratacion" ,header:"Estado de hidratacion" },
    {field: "estadomucoso" ,header:"Estado Mucoso" },
    {field: "oral" ,header:"Estado de la boca" },
    {field: "rectal" ,header:"Estado del Recto" },
    {field: "vulvarpropulcal" ,header:"Estado de La vulvapropural" },
    {field: "observaciones" ,header:"Observaciones" }

  ]
    
}

  showDialog(){
    this.visible = true;
  }

 loadReady(){
 this.analisisService.obtenerAnalisis().subscribe(
  (response : analisis[])=>{
    let analisis : analisis[]=[];
    for(let i =0; i < response.length; i++){
      let Analisis= response[i] as analisis;
    analisis.push(Analisis);
    }
    this.Analisis= analisis;
    console.log("que sale " + response);
  },(error) => {
    console.error('Error al cargar medicamentos', error);
    this.mensajeError = 'Error al cargar los medicamentos.';
  }
  );
    }


    abrirModal(analisis: analisis) {
      // Inicializa el formulario con los datos del medicamento seleccionado
      this.analisisSeleccionado = analisis;
      this.analisisForm.setValue({
        codAnalisis: analisis.codAnalisis,
        actitud: analisis.actitud,
        condicorporal: analisis.condicorporal,
        estadohidratacion:analisis.estadohidratacion,
        estadoconjutival: analisis.estadoconjutival,
        estadomucoso: analisis.estadomucoso,
        oral:analisis.oral,
        rectal:analisis.rectal,
        vulvarpropulcal: analisis.vulvarpropulcal,
        observaciones:analisis.observaciones

      });
  
      this.visibleEdicion = true;
     
    }


    guardarCambios(){


      this.analisisSeleccionado.codAnalisis=this.analisisForm.value.codAnalisis;      
      this.analisisSeleccionado.actitud=this.analisisForm.value.actitud;
this.analisisSeleccionado.condicorporal=this.analisisForm.value.condicorporal;
this.analisisSeleccionado.estadohidratacion=this.analisisForm.value.estadohidratacion;
this.analisisSeleccionado.estadoconjutival=this.analisisForm.value.estadoconjutival;
this.analisisSeleccionado.estadomucoso=this.analisisForm.value.estadomucoso;
this.analisisSeleccionado.oral=this.analisisForm.value.oral;
this.analisisSeleccionado.rectal=this.analisisForm.value.rectal;
this.analisisSeleccionado.vulvarpropulcal=this.analisisForm.value.vulvarpropulcal;
this.analisisSeleccionado.observaciones=this.analisisForm.value.observaciones;

this.analisisService.actualizarAnalsis(this.analisisSeleccionado.codAnalisis,this.analisisSeleccionado).subscribe(
  (resultado) => {
    console.log('Analsis actualizado con éxito:', resultado);
    this.visible = false;
    this.visibleEdicion=false;
  },
  (error) => {
    console.error('Error al actualizar el Analisis:', error);
    // Manejo de errores
  }
)
    }



  }
 

 

