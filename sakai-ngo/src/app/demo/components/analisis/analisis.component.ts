import { Component, OnInit,ElementRef, Renderer2  } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { Messages } from 'primeng/messages';
import {analisis} from '../../module/analisis'
import { AnalisisService } from '../../service/analisis.service';
import { Router } from '@angular/router';
import {ActivatedRoute } from '@angular/router';
import { TableModule } from 'primeng/table';

@Component({
  selector: 'app-analisis',
  templateUrl: './analisis.component.html',
  styleUrls: ['./analisis.component.scss']
})

export class AnalisisComponent implements OnInit {

  itemss: MenuItem[] | undefined;
  mensajeError : String =''
  messages: Messages[]=[];
   Analisi: analisis[]=[];
   mensajeExito : string=''
  analicis : analisis={
    codAnalisis: null,
    actitud: null,
    condicorporal: null,
    estadohidratacion: null,
    estadoconjutival: null,
    estadomucoso: null,
    oral: null,
    rectal: null,
    observaciones: null,
    vulvarpropulcal: null,
    nombre: null,
    codRegistro: new analisis
  }
  codRegistro: any;

  inputStyles = {
    'margin-right': '15px',
    'margin-bottom': '10px'
  };
  constructor(  private router : Router,
    private route :ActivatedRoute,
    private AnalisisService:AnalisisService,
    private renderer: Renderer2, private el: ElementRef){
      this.renderer.setStyle(this.el.nativeElement, 'margin-right', this.inputStyles['margin-right']);
      this.renderer.setStyle(this.el.nativeElement, 'margin-bottom', this.inputStyles['margin-bottom']);

      
    }
    textareaStyles: { [key: string]: string } = {
      'height': '150px',  //  aqui Ajusta la altura según tus necesidades
      'width': '100%',    // el ancho según tus necesidades
      'resize': 'vertical' // Controla la dirección de redimensionamiento vertical
    };
    
  ngOnInit(): void {
   
    
    this.itemss = [
      { label: 'Inicio', icon: 'pi pi-fw pi-home', routerLink:['/'] },
      { label: 'lista de resgistros', icon: 'pi pi-fw pi-calendar',routerLink: ['/registroLista'] },
     
  ];

  this.route.params.subscribe(params =>{

    this.codRegistro=params['codRegistro']
  })

  }

  crearAnalisis(){

    this.AnalisisService.crearAnalisis(this.analicis,this.codRegistro)
    .subscribe(
      (response :analisis)=>{

        let analis= response as analisis
        this.Analisi.push(analis);
        console.log('se creo  correctamente??', response );

        
        if(response && response.codAnalisis){
          const codAnalsis=response.codAnalisis;
         console.log("que numero sale", codAnalsis);

         this.router.navigate(['/diagnostico',codAnalsis]);
        this.mensajeExito = 'Registro creado con éxito';

       
      }
  });
    
  }
 
  


  

 
}
