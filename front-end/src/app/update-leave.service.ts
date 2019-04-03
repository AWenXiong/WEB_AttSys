import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams, } from '@angular/common/http';
import {Observable} from 'rxjs';
import {tap} from 'rxjs/operators';
import { UpdateLeave } from 'src/app/updateLeave';

@Injectable({
  providedIn: 'root'
})
export class UpdateLeaveService {
  private url = 'http://39.105.178.115:8080/outrecord/update';
  headers = new HttpHeaders();
  getHeaders(): HttpHeaders {
    let headers = new HttpHeaders();
    headers.append('Access-Control-Allow-Origin', '*');
    headers.append('Access-Control-Allow-Methods', 'POST, GET, OPTIONS, PUT');
    headers.append('Accept', 'application/json');
    headers.append('content-type', 'application/json');
    return headers;
  }
  updateApply(apply: UpdateLeave): Observable<any> {
    return this.http.post<any>(this.url, apply, {headers: this.getHeaders()}).pipe(
      tap(data => console.log(data),
        function () {
          console.log('请假记录更新失败');
        }
      ));
  }
  constructor(
    private http: HttpClient
  ) { }
}
