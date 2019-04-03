import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';

import {Observable, of} from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class TestService {
  private testUrl = 'http://localhost:8080/test/2';
  headers = new HttpHeaders();
  getHeaders(): HttpHeaders {
    let headers = new HttpHeaders();
    headers.append('Access-Control-Allow-Origin' , '*');
    headers.append('Access-Control-Allow-Methods', 'POST, GET, OPTIONS, PUT');
    headers.append('Accept', 'application/json');
    headers.append('content-type', 'application/json');
    return headers;
  }

  getHero(): Observable<any> {
    return this.http.get<any>(this.testUrl).pipe(
      tap(data => console.log(data),
      function() {
        console.log('233');
      }
    ));
  }
  constructor(
    private http: HttpClient
  ) {}
}
