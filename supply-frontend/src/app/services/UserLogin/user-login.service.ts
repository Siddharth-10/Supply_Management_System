import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserLoginService {

  constructor(private httpClient:HttpClient) { }

  checkUsername(username): Observable<any>{
    return this.httpClient.get('http://localhost:8080/supply_management/webapi/userlogin/checkUsername/'+username);


  }
}
