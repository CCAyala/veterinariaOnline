import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { tap } from 'rxjs';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class CitaMedicaService {
  httpHeaders: HttpHeaders = new HttpHeaders();
  params: HttpParams = new HttpParams();
  constructor(
    private http: HttpClient
  ) {
    this.httpHeaders = this.httpHeaders.append(
      'Content-Type',
      'application/json'
    );
  }

  listaVeterinarios(
    codEstado: string,
   
  ) {
    const serviceUrl =
      
      'localhost:8080/veterinario/listarVeterinarios';
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      // Authorization: 'Bearer ' + token.substring(1, token.length - 1),
    });
    const params = new HttpParams()
      .set('codEstado', codEstado)
    

      //  GENERA EL NUI
      let options = {
        headers: headers,
        params: params,
      };
  
      return this.http.get(serviceUrl, options).pipe(
        tap(
          (data: any) => {
            return data;
          },
          (error) => {
            throw error;
          }
        )
      );
    }
}
