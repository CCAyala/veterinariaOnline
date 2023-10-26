import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Mascotas } from '../module/mascota';

@Injectable({
  providedIn: 'root'
})
export class MascotaService {

  url : string ='http://localhost:8080/mascota'

  constructor(private http : HttpClient) { }

  getMascotas(): Observable<Mascotas[]>{
    return this.http.get<Mascotas[]>(this.url+'/listarMascotas');
  }

  buscarMascotas(codmasco: number): Observable<Mascotas>{
       return this.http.get<Mascotas>(this.url+'/buscaMascota/'+ codmasco)
  }

  eliminarProducto(codmasco:number): Observable<Mascotas>{
    return this.http.delete<any>(this.url+'/eliminar/'+codmasco)
  }

  actualizarMascota(codmasco: number, Mascotas: Mascotas): Observable<Mascotas> {
    return this.http.put<Mascotas>(`${this.url}/modificarMascota/${codmasco}`, Mascotas);
  
}

}