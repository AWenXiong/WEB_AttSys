import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams, } from '@angular/common/http';
import {Observable} from 'rxjs';
import {tap} from 'rxjs/operators';
import { Login } from './login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private url = 'http://39.105.178.115:8080/staff/login';
  headers = new HttpHeaders();
  getHeaders(): HttpHeaders {
    let headers = new HttpHeaders();
    headers.append('Access-Control-Allow-Origin', '*');
    headers.append('Access-Control-Allow-Methods', 'POST, GET, OPTIONS, PUT');
    headers.append('Accept', 'application/json');
    headers.append('content-type', 'application/json');
    return headers;
  }

  login(user: Login): Observable<any> {
    return this.http.post<any>(this.url, user, {headers: this.getHeaders()}).pipe(
      tap(data => {
        console.log(data);
      }, function () {
          console.log('233');
        }
      ));
  }

  constructor(
    private http: HttpClient
  ) {
  }
}
