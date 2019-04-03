import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams, } from '@angular/common/http';
import {Observable} from 'rxjs';
import {tap} from 'rxjs/operators';
import {SearchRecord} from './searchRecord';
import {DeleteRecord} from './deleteRecord';
@Injectable({
  providedIn: 'root'
})
export class WorkerSearchVacateService {

  private url = 'http://39.105.178.115:8080/leaverecord/querybyid';
  private deleteUrl = 'http://39.105.178.115:8080/leaverecord/delete';
  headers = new HttpHeaders();
  getHeaders(): HttpHeaders {
    let headers = new HttpHeaders();
    headers.append('Access-Control-Allow-Origin', '*');
    headers.append('Access-Control-Allow-Methods', 'POST, GET, OPTIONS, PUT');
    headers.append('Accept', 'application/json');
    headers.append('content-type', 'application/json');
    return headers;
  }

  getAllRecords(staffId: SearchRecord): Observable<any> {
    return this.http.post<any>(this.url, staffId, {headers: this.getHeaders()}).pipe(
      tap(data => console.log(data),
        function () {
          console.log('获取记录申请失败');
        }
      ));
  }
  deleteRecords(applyId: DeleteRecord): Observable<any> {
    return this.http.post(this.deleteUrl, applyId, {headers: this.getHeaders()}).pipe(
      tap(data => console.log(data),
        function () {
          console.log('删除请求失败');
        }
      )
    );
  }
  constructor(
    private http: HttpClient
  ) { }
}
