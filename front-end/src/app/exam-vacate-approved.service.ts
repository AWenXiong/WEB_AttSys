import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams, } from '@angular/common/http';
import {Observable} from 'rxjs';
import {tap} from 'rxjs/operators';
import {SearchRecord} from './searchRecord';

@Injectable({
  providedIn: 'root'
})
export class ExamVacateApprovedService {
  private url = 'http://39.105.178.115:8080/leaverecord/queryrecord';
  private leaveUrl = 'http://39.105.178.115:8080/outrecord/getallapply';
  headers = new HttpHeaders();
  getHeaders(): HttpHeaders {
    let headers = new HttpHeaders();
    headers.append('Access-Control-Allow-Origin', '*');
    headers.append('Access-Control-Allow-Methods', 'POST, GET, OPTIONS, PUT');
    headers.append('Accept', 'application/json');
    headers.append('content-type', 'application/json');
    return headers;
  }
  getAllRecords(managerId: SearchRecord): Observable<any> {
    return this.http.post<any>(this.url, managerId, {headers: this.getHeaders()}).pipe(
      tap(data => console.log(data),
        function () {
          console.log('23333');
        }
      ));
  }
  getApprovedRecords(managerId: SearchRecord): Observable<any> {
    return this.http.post<any>(this.url, managerId, {headers: this.getHeaders()}).pipe(
      tap(data => console.log(data),
        function () {
          console.log('23333');
        }
      ));
  }
  getApprovedLeaveRecords(managerId: SearchRecord): Observable<any> {
    return this.http.post<any>(this.leaveUrl, managerId, {headers: this.getHeaders()}).pipe(
      tap(data => console.log(data),
        function () {
          console.log('23333');
        }
      ));
  }
  constructor(
    private http: HttpClient
  ) { }
}
