import { Injectable } from '@angular/core';
import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class FileUploadService {
    
  // API url
  //baseApiUrl = "https://file.io"
  baseApiUrl = "http://localhost:8082/portafolio"
    
  constructor(private http:HttpClient) {}

  upload2(file: File, id: number): Observable<HttpEvent<any>> {
    const formData: FormData = new FormData();
    formData.append('file', file);

    const req = new HttpRequest('POST', this.baseApiUrl+"/upload/"+id, formData, {
      reportProgress: true,
      responseType: 'text'
    });

    return this.http.request(req);
  }

  upload(file: File, id: number): Observable<any> {
    const formData: FormData = new FormData();
    formData.append('file', file);

    const req = new HttpRequest('POST', this.baseApiUrl+"/upload/"+id, formData, {
      reportProgress: true,
      responseType: 'text'
    });

    return this.http.request(req);
  }

  // getFiles(id: number) {
  //   const req = new HttpRequest('POST', this.baseApiUrl+"/get/"+id, {
  //     reportProgress: true,
  //     responseType: 'text'
  //   });
  //   return this.http.request<Observable<any>>(req);
  //   //return this.http.post<Observable<any>>(`${this.baseApiUrl}/get/`+id, {responseType: 'text'});
  // }

  getFile2(id: number):Observable<any> {
    return this.http.get(this.baseApiUrl+"/get2/"+id);
  }
}