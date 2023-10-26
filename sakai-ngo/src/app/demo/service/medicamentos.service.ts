import { Injectable } from '@angular/core';
import { medicamentos } from '../module/medicamentos';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class MedicamentosService {
  url : string ='http://localhost:8080/medicamentos'

  constructor(private Http: HttpClient) { }


  crearMedicamento(medicamento: medicamentos):Observable<medicamentos>{
    let headers= new HttpHeaders();
    headers=headers.set('content-type','application/json')
    return this.Http.post<medicamentos>(this.url+'/crearMedicamento',JSON.stringify(medicamento),{headers: headers});
  }

  
 getMedicamentos(): Observable<medicamentos[]>{
   return this.Http.get<medicamentos[]>(this.url+'/listarMedicamentos');
 }

 actualizarMedicamento(idMedicamento: number, medicamentos:medicamentos):Observable<medicamentos>{
  return this.Http.put<medicamentos>(`${this.url}/modificarMedicamento/${idMedicamento}`,medicamentos);
 }
 
}
