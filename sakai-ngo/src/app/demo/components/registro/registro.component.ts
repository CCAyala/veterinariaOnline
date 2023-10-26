import { Component, OnInit,ElementRef, Renderer2  } from '@angular/core';
import { MascotaService } from '../../service/mascota.service';
import { registro } from '../../module/registro';
import { RealizaService } from '../../service/registro.service';
import { Mascotas } from '../../module/mascota';
import { Router } from '@angular/router';
import { Button } from 'primeng/button';
import { PrimeIcons, MenuItem } from 'primeng/api';
import { DialogService } from 'primeng/dynamicdialog';
import { FormBuilder, FormGroup, Validators,FormControl } from '@angular/forms';
import { Messages } from 'primeng/messages';
import { InputTextModule } from 'primeng/inputtext';
@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.scss']
})
export class RegistroComponent  implements OnInit{

  mostrarMascota : boolean = true;
  searchText : String = '';
  Mascotas: Mascotas[] = [];
  Realiza : registro = new registro();
  Realiz : registro []=[];
  mensajeExito : string=''
  mensajeError : String =''
  messages: Messages[]=[];
  registroform:FormGroup;
  editable :boolean=true;
  itemss: MenuItem[] | undefined;
  routerLink: any;
  codRegistro=0;

  inputStyles = {
    'margin-right': '15px',
    'margin-bottom': '10px'
  };
  reali: registro={
    codRegistro:null,
    nombreMasco:null,
    estadoCardioMuscular:null,
    estadoDigestivo:null,
    estadoGenitario:null,
    estadoLocomocion:null,
    estadoModuloslinfaticos:null,
    estadoOjos:null,
    estadoPielyanex:null,
    estadoRespiratorio:null,
    estadoSistemaNervioso:null, 
    estadomMusculoEsqueletico:null,
    fechaIng:null
  }

  constructor(
    private MascotaService : MascotaService,
     private realizaService : RealizaService,
     private router : Router,
     private fb: FormBuilder,
     private renderer: Renderer2, private el: ElementRef
     ) { 
      this.renderer.setStyle(this.el.nativeElement, 'margin-right', this.inputStyles['margin-right']);
      this.renderer.setStyle(this.el.nativeElement, 'margin-bottom', this.inputStyles['margin-bottom']);
    }
     
  ngOnInit(): void {
   
    
    this.itemss = [
      { label: 'Inicio', icon: 'pi pi-fw pi-home', routerLink:['/'] },
      { label: 'Analisis', icon: 'pi pi-fw pi-calendar',routerLink: ['/registros'] },
     
  ];

  }

  buscarMascotas(){
    if(this.searchText.trim()=== ''){
      this.mensajeError = '';
      return;
    }else{
      const codigoMascota = Number(this.searchText);
      if(!isNaN(codigoMascota)){
      this.MascotaService.buscarMascotas(codigoMascota)
      .subscribe(
      (response : Mascotas )=>{
       if(response){
          this.Mascotas = [response];
          this.mostrarMascota = true; // Mostrar resultados
          this.mensajeError='';
       }else{
        this.Mascotas=[];
        this.mostrarMascota= false;
        this.mensajeError = 'No se encontró la mascota con el código ingresado.';

       } },
       
       (error) => {
        console.error('Error al buscar la mascota', error);
        this.mensajeError = 'Mascota no encontrada Por favor, inténtelo de nuevo.';
      }
      );
    }
    
      
    
  }
}


  crearRegistro() {

    if (
      !this.reali.estadoDigestivo ||
      !this.reali.fechaIng ||
      !this.reali.estadoRespiratorio ||
      !this.reali.estadomMusculoEsqueletico ||
      !this.reali.estadoSistemaNervioso ||
      !this.reali.estadoPielyanex ||
      !this.reali.estadoOjos ||
      !this.reali.estadoGenitario ||
      !this.reali.estadoLocomocion ||
      !this.reali.estadoCardioMuscular ||
      !this.reali.estadoModuloslinfaticos 
    ) {
      this.mensajeError = 'Por favor, complete todos los campos obligatorios.';
      setTimeout(() => {
      this.mensajeError = '';
      }, 4000);
      return; // Detén la ejecución si falta algún campo
    }   

    if (this.Mascotas && this.Mascotas.length > 0) {
      const codMasco = this.Mascotas[0].codmasco;
      
   this.realizaService.crearRegistro(this.reali,codMasco).subscribe(
    
      (response : registro)=>{
        
         let registro=response as registro;
         this.Realiz.push(registro);
         console.log('se creo  correctamente??', response );

        if(response && response.codRegistro){
          const codregistro=response.codRegistro;
         console.log("que numero sale", codregistro);

         this.router.navigate(['/analisis',codregistro]);
        this.mensajeExito = 'Registro creado con éxito';

       

        this.searchText = '';
        setTimeout(() => {
          this.mensajeExito = '';
        }, 3000);
        
      
      }

      (error) =>{
        console.error('error al crear registro',error);
     
        this.mensajeError = 'Se ah registrado con exito';
        setTimeout(() => {
          this.mensajeError = '';
        }, 3000);
      }
    });



  }
  }
  }
