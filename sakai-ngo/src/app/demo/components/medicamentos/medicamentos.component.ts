import { Component } from '@angular/core';
import { medicamentos } from 'src/app/demo/module/medicamentos';
import { MedicamentosService } from 'src/app/demo/service/medicamentos.service';
import { PrimeIcons, MenuItem } from 'primeng/api';
import { DialogService } from 'primeng/dynamicdialog';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Location } from '@angular/common';
import { Messages } from 'primeng/messages';


@Component({
  selector: 'app-medicamentos',
  templateUrl: './medicamentos.component.html',
  styleUrls: ['./medicamentos.component.scss'],
  
})
export class MedicamentosComponent {
  searchText = '';
  mensajeError='';
  mostrarRealiza = true;
  items: MenuItem[];
  visible: boolean = false;
  itemss: MenuItem[] | undefined;
cols: any;

  Medicamento : medicamentos[];
  medicamentoForm: FormGroup;
  messages: Messages[]=[];
  loading: boolean = false;
  mensajeExito: string;
  medicamentoSeleccionado : medicamentos;
  modoEdicion = false; // Inicialmente, no estamos en modo edición
  location: any;
  visibleCreacion: boolean = false;
  visibleEdicion: boolean = false;
   medicamen: medicamentos ={
    idMedicamento:null,
    nombre:null,
    tipoMedicamento:null
   }

  constructor(private medicamentoService : MedicamentosService,
    private dialogService: DialogService,
    private formBuilder: FormBuilder
     ) { this.medicamentoForm = this.formBuilder.group({
      idMedicamento: [null],
      nombre: [null, Validators.required], // Agrega validadores si es necesario
      tipoMedicamento: [null, Validators.required], // Agrega validadores si es necesario
    });  }

    ngOnInit(): void {

      this.itemss = [
        { label: 'Inicio', icon: 'pi pi-fw pi-home' },
        { label: 'Analisis', icon: 'pi pi-fw pi-calendar',routerLink: ['/registros'] },
       
    ];
  
  
      this.items = [
        {
            label: 'New',
            icon: PrimeIcons.PLUS,
            command: () => this.showDialog(),
            
        },
      ],
      this.loadMedicamento();
      this.cols=[
        {field:"idMedicamento", header:"Id"},
        {field:"nombre", header:"nombre medicamento"},
        {field:"tipoMedicamento", header:"tipo medicamento"}];
    }
 
  showDialog(){
    this.visible = true;
  }

  loadMedicamento(){
    this.medicamentoService.getMedicamentos().subscribe
    ((response : medicamentos[])=>{
      let Medicamento : medicamentos[]=[];
      for (let i=0; i< response.length; i++){
        let medicamento=response[i] as medicamentos;
        Medicamento.push(medicamento);
      }

      this.Medicamento=Medicamento;
      console.log("que sale lista " + response);
      this.visible=false;
    },(error) => {
      console.error('Error al cargar medicamentos', error);
      this.mensajeError = 'Error al cargar los medicamentos.';
    }
    );
  }
  mostrarModalCreacion() {
    this.visibleCreacion=true;
    this.visibleEdicion = false;
}

  

  
    
    crearMedicamento() {

      
        this.visibleCreacion = false;
        // También puedes enviar el nuevo medicamento al servidor si es necesario
        this.medicamentoService.crearMedicamento(this.medicamen).subscribe(
          (response: any) => {
            let medicamento = response as medicamentos;
            this.Medicamento.push(medicamento);
            console.log("que sale " , response);

            this.searchText = '';
      setTimeout(() => {
        this.mensajeExito = '';
      }, 3000);
          },
          (error) => {
            console.error('Error al crear el medicamento', error);
            // Manejar errores si es necesario
          }
        );
      }



      abrirModal(medicamento: medicamentos) {
        // Inicializa el formulario con los datos del medicamento seleccionado
        this.medicamentoSeleccionado = medicamento;
        this.medicamentoForm.setValue({
          idMedicamento: medicamento.idMedicamento,
          nombre: medicamento.nombre,
          tipoMedicamento: medicamento.tipoMedicamento,
        });
    
        this.visibleEdicion = true;
        this.visibleCreacion=false;
      }
    
      guardarCambios() {
        // Actualiza los datos del medicamento seleccionado con los valores del formulario
        this.medicamentoSeleccionado.idMedicamento=this.medicamentoForm.value.idMedicamento;
        this.medicamentoSeleccionado.nombre = this.medicamentoForm.value.nombre;
        this.medicamentoSeleccionado.tipoMedicamento = this.medicamentoForm.value.tipoMedicamento;
    
        this.medicamentoService.actualizarMedicamento(this.medicamentoSeleccionado.idMedicamento,
          this.medicamentoSeleccionado).subscribe(
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

  

    



