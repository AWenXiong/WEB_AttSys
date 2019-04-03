import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams, } from '@angular/common/http';
import {Observable} from 'rxjs';
import {tap} from 'rxjs/operators';
import {WorkerSearchCompany} from './workerSearchCompany';

@Injectable({
  providedIn: 'root'
})
export class SearchCompanyService {

  private myUrl = 'http://39.105.178.115:8080/company/information';
  headers = new HttpHeaders();
  getHeaders(): HttpHeaders {
    let headers = new HttpHeaders();
    headers.append('Access-Control-Allow-Origin', '*');
    headers.append('Access-Control-Allow-Methods', 'POST, GET, OPTIONS, PUT');
    headers.append('Accept', 'application/json');
    headers.append('content-type', 'application/json');
    return headers;
  }

  getResult(body: WorkerSearchCompany): Observable<any> {
    return this.http.post<any>(this.myUrl, body, {headers: this.getHeaders()}).pipe(
      tap(data => console.log(data),
        function () {
          console.log('fuck');
        }
      ));
  }
  constructor(
    private http: HttpClient
  ) { }
}
