import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { diagnostico } from '../module/diagnostico';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DiagnosticoService {

  url : string ='http://localhost:8080/diagnostico'
  constructor(private HttpClient: HttpClient) { }

  
  obtenerDiagnosticos(): Observable<diagnostico[]>{
    return this.HttpClient.get<diagnostico[]>(this.url+'/listarDiagnosticos');
  }

  buscarDiagnostico(nDiagnostico: number): Observable<diagnostico>{
    return this.HttpClient.get<diagnostico>(this.url+'/buscarDiagnostico/'+ nDiagnostico)
}

actualizarDiagnostico(nDiagnostico: number, diagnostico: diagnostico): Observable<diagnostico> {
  return this.HttpClient.put<diagnostico>(`${this.url}/modificarDiagnostico/${nDiagnostico}`, diagnostico);

}

crearDiagnostico(Diagnostico: diagnostico, codAnalsis: number):Observable<diagnostico>{
  const url = `${this.url}/crearDiagnostico/${codAnalsis}`;
   return this.HttpClient.post<diagnostico>(url,Diagnostico)
 }

}
