import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams, } from '@angular/common/http';
import {Observable} from 'rxjs';
import {tap} from 'rxjs/operators';
import {SearchRecord} from './searchRecord';
import {ManagerApproveVacateApply} from './managerApproveVacateApply';

@Injectable({
  providedIn: 'root'
})
export class ExamVacateService {

  private url = 'http://39.105.178.115:8080/leaverecord/getallapply';
  private approveUrl = 'http://39.105.178.115:8080/leaverecord/check';
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
  approveApply(apply: ManagerApproveVacateApply): Observable<any> {
    return this.http.post<any>(this.approveUrl, apply, {headers: this.getHeaders()}).pipe(
      tap(data => console.log(data),
        function () {
          console.log('23333');
        }
      )
    );
  }
  constructor(
    private http: HttpClient
  ) { }
}
