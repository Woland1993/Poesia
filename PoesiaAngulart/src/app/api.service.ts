import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable} from 'rxjs';
import {Estudiante} from './modelo/Estudiante';
import {Response} from './modelo/Response'
@Injectable({
  providedIn: 'root'
})

export class ApiService {
  
url='http://localhost:7001';
  constructor(private http:HttpClient ) { }
 crearAlumno(form:Estudiante):Observable<Response>{
  const httpOptions = {
    headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Credentials': 'true',
        'Access-Control-Allow-Headers': 'origin, content-type, accept, authorization',
        'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,HEAD'})
};
  let direccion=this.url+'/EventoPesia/webresources/ControllersEstudiante/created' 
  return this.http.post<Response>(direccion,form,httpOptions);
 }
}



/*export class ApiService {

  constructor() { }
  response: AxiosResponse<any> | Promise<any> | string = ""; 

  async anyRequest(body: any, serviceUrl: string, metodo: metodoHTTP){
    try{
      const response = await axios({
        method: metodo,
        baseURL: 'localhost:7001',
        url: serviceUrl,
        data: body,
        timeout: 5000
      });
      return response;
    }catch(error){
      console.error(error);
      alert("Error en la peticion :(");
      return "La peticion ha fallado...";
    }
  }
}
*/