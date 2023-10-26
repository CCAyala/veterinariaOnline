import { Component, ElementRef, OnInit, Renderer2 } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { Messages } from 'primeng/messages';
import { diagnostico} from '../../module/diagnostico'
import { ActivatedRoute, Router } from '@angular/router';
import { DiagnosticoService } from '../../service/diagnostico.service';
import { DialogService } from 'primeng/dynamicdialog';
@Component({
  selector: 'app-diagnostico',
  templateUrl: './diagnostico.component.html',
  styleUrls: ['./diagnostico.component.scss']
})
export class DiagnosticoComponent implements OnInit {
  
  displayModal = false;
  selectedOption: string | undefined;
  visibleEdicion: boolean=false;
  itemss: MenuItem[] | undefined;
  mensajeError : String =''
  messages: Messages[]=[];
  Diagnosti : diagnostico[]=[];
  mensajeExito : string=''
  codAnalisis : any;
  diagnos : diagnostico ={
    nDiagnostico: null,
    estado: null,
    descripccion: null,
    fecha: null,
    nombre: null
  }
  inputStyles = {
    'margin-right': '15px',
    'margin-bottom': '10px',
    'width': '25%'
  };
  textareaStyles: { [key: string]: string } = {
    'height': '150px',  //  aqui Ajusta la altura según tus necesidades
    'width': '100%',    // el ancho según tus necesidades
    'resize': 'vertical' // Controla la dirección de redimensionamiento vertical
  };
  codigoDiagnostico: number;
  mostrarDialogoExito: boolean;
constructor(private router : Router,
  private route :ActivatedRoute,
  private DiagnosticoService: DiagnosticoService,
  private renderer: Renderer2, private el: ElementRef,
  private dialogService: DialogService){
    this.renderer.setStyle(this.el.nativeElement, 'margin-right', this.inputStyles['margin-right']);
      this.renderer.setStyle(this.el.nativeElement, 'margin-bottom', this.inputStyles['margin-bottom']);

  }

  ngOnInit(): void {

    this.itemss = [
      { label: 'Inicio', icon: 'pi pi-fw pi-home', routerLink:['/'] },
      { label: 'lista de registros', icon: 'pi pi-fw pi-calendar',routerLink: ['/registroLista'] },
    ];
    this.route.params.subscribe(params =>{

      this.codAnalisis=params['codAnalisis']
    });
  
    
  }


  crearDiagnostico(){

    this.DiagnosticoService.crearDiagnostico(this.diagnos,this.codAnalisis).subscribe(
      (response : diagnostico)=>{
        let Diagnos  = response as diagnostico
        this.Diagnosti.push(Diagnos);
        console.log('se creo  correctamente??', response );

        this.displayModal=true;

        this.codigoDiagnostico = response.nDiagnostico; // Almacena el código de diagnóstico
        
      }
    )
  }




  openModal() {
    const ref = this.dialogService.open(DiagnosticoComponent, {
      header: 'Selecciona una opción',
      width: '70%',
      contentStyle: { 'max-height': '500px', 'overflow': 'auto' },
    });

    ref.onClose.subscribe((option: string) => {
      if (option) {
        this.selectedOption = option; // Maneja la opción seleccionada
      }
      this.displayModal = false; // Cierra el modal
    });
}








}