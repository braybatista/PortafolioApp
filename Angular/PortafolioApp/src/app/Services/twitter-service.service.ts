import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TwitterService {

  api_url = 'http://localhost:8082/portafolio/tweets';
  
  constructor(private http: HttpClient) { }

  getRecentTweets(){
    return this.http.get<any[]>(this.api_url); 
  }
}
