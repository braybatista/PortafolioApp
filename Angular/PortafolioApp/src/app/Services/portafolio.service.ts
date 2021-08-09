import { Injectable } from '@angular/core';
import { Portafolio } from '../Models/Portafolio';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class PortafolioService {


  private Url = 'http://localhost:8082/portafolio'

  constructor(private http: HttpClient) { }

  getPortafolio(){
    return this.http.get<Portafolio[]>(this.Url)
  }

  addEditPortafolio(port: Portafolio){
    return this.http.post<Portafolio>(this.Url, port);
  }
}
