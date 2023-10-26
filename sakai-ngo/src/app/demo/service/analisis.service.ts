import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { analisis } from '../module/analisis';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AnalisisService {

  url : string ='http://localhost:8080/analisis'

  constructor(private HttpClient: HttpClient) { }


  crearAnalisis(Analisis: analisis, codRegistro: number):Observable<analisis>{
    const url = `${this.url}/crearAnalisis/${codRegistro}`;
     return this.HttpClient.post<analisis>(url,Analisis)
   }


   obtenerAnalisis():Observable<analisis[]>{
    return this.HttpClient.get<analisis[]>(this.url+'/listarAnalisis');
   }


   buscarXnombre(nombre: String):Observable<analisis[]>{

  return this.HttpClient.get<analisis[]>(this.url+'/buscarXNombre/'+nombre);
   }

   actualizarAnalsis(codAnalsis: number, analisis: analisis): Observable<analisis> {
    return this.HttpClient.put<analisis>(`${this.url}/modificarAnalisis/${codAnalsis}`, analisis);
  
  }

  buscaAnalisis(codAnalisis: number):Observable<analisis>{
    return this.HttpClient.get<analisis>(this.url+'/buscaAnalisis/'+codAnalisis)
  }
}
