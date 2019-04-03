import { Component, OnInit } from '@angular/core';
import {WorkerSearchVacateService} from '../../worker-search-vacate.service';
import { LocalStorage } from 'src/app/LocalStorage';
import {SearchRecord} from '../../searchRecord';
import {VacateRecords} from '../../vacateRecords';
import {forEach} from '@angular/router/src/utils/collection';
import {Router} from '@angular/router';
import {DeleteRecord} from '../../deleteRecord';
import {NgZone} from '@angular/core';
import {ChangeDetectorRef} from '@angular/core';
import {PersonalInformation} from 'src/app/personalInformation';

@Component({
  selector: 'app-search-vacate',
  templateUrl: './search-vacate.component.html',
  styleUrls: ['./search-vacate.component.css']
})
export class SearchVacateComponent implements OnInit {
  showInfo = new PersonalInformation();
  staffId: any;
  myRecords = new SearchRecord();
  deleteId = new DeleteRecord();
  pendingRecords = new Array<VacateRecords>();
  refusedRecords = new Array<VacateRecords>();
  approvedRecords = new Array<VacateRecords>();
  recordReason: string;

  showRecoeds(): void {
    this.myRecords.sid = this.staffId;
    this.workerSearchVacateService.getAllRecords(this.myRecords).subscribe(
      (data) => {
        for (let el of data) {
          let curRecord = new VacateRecords();
          if (el['status'] === 'PASSED') {
            curRecord.applyId = el['recordId'];
            curRecord.startTime = el['startTime'];
            curRecord.endTime = el['endTime'];
            curRecord.leaveKind = this.transKind(el['leaveKind']);
            curRecord.sir = el['passStaffName'];
            curRecord.reason = el['reason'];
            this.approvedRecords.push(curRecord);
          } else if (el['status'] === 'REJECTED') {
            curRecord.applyId = el['recordId'];
            curRecord.startTime = el['startTime'];
            curRecord.endTime = el['endTime'];
            curRecord.leaveKind = this.transKind(el['leaveKind']);
            curRecord.sir = el['passStaffName'];
            curRecord.reason = el['reason'];
            this.refusedRecords.push(curRecord);
          } else if (el['status'] === 'PENDING') {
            curRecord.applyId = el['recordId'];
            curRecord.startTime = el['startTime'];
            curRecord.endTime = el['endTime'];
            curRecord.leaveKind = this.transKind(el['leaveKind']);
            curRecord.reason = el['reason'];
            this.pendingRecords.push(curRecord);
          }
        }
      }
    );
  }
  transKind(kind: number): string {
    let result;
    if (kind === 0) {
      result = '事假';
    } else if (kind === 1) {
      result = '工伤假';
    } else if (kind === 2) {
      result = '病假';
    } else if (kind === 3) {
      result = '婚假';
    } else if (kind === 4) {
      result = '产假';
    } else if (kind === 5) {
      result = '年假';
    } else if (kind === 6) {
      result = '探亲假';
    } else if (kind === 7) {
      result = '丧假';
    }
    return result;
  }
  onLook(applyId: string): void {
    this.myRecords.sid = this.staffId;
    this.workerSearchVacateService.getAllRecords(this.myRecords).subscribe(
      (data) => {
        for (let el of data) {
          if (el['recordId'] === applyId) {
            this.recordReason = el['reason'];
          }
        }
        alert(this.recordReason);
      }
    );
  }
  onEdit(applyId: string): void {
    this.LSData.setObject('updateVacateId', applyId);
    this.router.navigateByUrl('/search-vacate/update');
  }
  onDelete(applyId: string): void {
    this.deleteId.recordId = applyId;
    this.workerSearchVacateService.deleteRecords(this.deleteId).subscribe(
      (data) => {
        if (data['success'] === true) {
          alert('success');
          this.pendingRecords = new Array<VacateRecords>();
          this.refusedRecords = new Array<VacateRecords>();
          this.approvedRecords = new Array<VacateRecords>();
          this.showRecoeds();
        } else {
          alert('error');
        }
      }
    );
  }
  exit(): void {
    this.LSData.removeAll();
    this.router.navigateByUrl('/login');
  }
  constructor(
    private LSData: LocalStorage,
    private router: Router,
    private workerSearchVacateService: WorkerSearchVacateService,
  ) {
  }

  ngOnInit() {
    this.staffId = this.LSData.getObject('staffId');
    this.showRecoeds();
    this.showInfo.staffId = this.LSData.getObject('staffId');
    this.showInfo.staffPosition = this.LSData.getObject('position');
    this.showInfo.staffDepartment = this.LSData.getObject('department');
  }

}
