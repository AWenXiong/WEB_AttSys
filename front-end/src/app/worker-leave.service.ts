import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams, } from '@angular/common/http';
import {Observable} from 'rxjs';
import {tap} from 'rxjs/operators';
import { OutApply } from 'src/app/outApply';

@Injectable({
  providedIn: 'root'
})
export class WorkerLeaveService {
  private url = 'http://39.105.178.115:8080/outrecord/add';

  headers = new HttpHeaders();
  getHeaders(): HttpHeaders {
    let headers = new HttpHeaders();
    headers.append('Access-Control-Allow-Origin', '*');
    headers.append('Access-Control-Allow-Methods', 'POST, GET, OPTIONS, PUT');
    headers.append('Accept', 'application/json');
    headers.append('content-type', 'application/json');
    return headers;
  }

  addLeaveApply(body: OutApply): Observable<any> {
    return this.http.post<any>(this.url, body, {headers: this.getHeaders()}).pipe(
      tap(data => console.log(data),
        function () {
          console.log('2345');
        }
      ));
  }
  constructor(
    private http: HttpClient
  ) { }
}
