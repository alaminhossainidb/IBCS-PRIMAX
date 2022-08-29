import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CommonService {

  public data : any;

  public value : any;

  baseUrl : string = "http://localhost:8080"
  constructor(
    public http : HttpClient
  ) { }


  public get(target: string){
    return this.http.get(this.baseUrl+target);
  }


  public post(payload: any, url : string) {
    return this.http.post(this.baseUrl+url, payload);
  }
}
