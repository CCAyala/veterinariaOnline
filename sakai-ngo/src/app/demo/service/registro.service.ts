import { Injectable } from '@angular/core';
import {registro} from '../module/registro'
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RealizaService {

  url : String = 'http://localhost:8080/registro';
  constructor(private httpClient: HttpClient) { }


  crearRegistro(Realiza: registro, codMasco: number):Observable<registro>{
   const url = `${this.url}/crearRegistro/${codMasco}`;
    return this.httpClient.post<registro>(url,Realiza)
  }

  getRegistros(): Observable<registro[]>{
    return this.httpClient.get<registro[]>(this.url+'/listaRegistro');
  }

  
  buscarRegistro(codRegistro: number): Observable<registro[]>{
    return this.httpClient.get<registro[]>(this.url+'/buscarRegistro/'+ codRegistro)
}

buscaRegistro(codRegistro: number): Observable<registro>{
   return this.httpClient.get<registro>(this.url+'/buscar/'+codRegistro)
}

buscaRegistr(codRegistro: number):Observable<registro[]>{
  return this.httpClient.get<registro[]>(this.url+'/buscar/'+codRegistro)
}

actualizarRegistro(codregistro: number, realiza: registro): Observable<registro> {
  return this.httpClient.put<registro>(`${this.url}/modificarRegistro/${codregistro}`, realiza);

}
}
