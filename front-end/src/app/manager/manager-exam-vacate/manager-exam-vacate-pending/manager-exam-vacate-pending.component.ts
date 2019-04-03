import { Component, OnInit } from '@angular/core';
import {ExamVacateService} from '../../../exam-vacate.service';
import { LocalStorage } from 'src/app/LocalStorage';
import {SearchRecord} from 'src/app/searchRecord';
import {ExamVacatePendingRecords} from 'src/app/examVacatePendingRecords';
import {forEach} from '@angular/router/src/utils/collection';
import {ManagerApproveVacateApply} from 'src/app/managerApproveVacateApply';
import {Router} from '@angular/router';
import {PersonalInformation} from 'src/app/personalInformation';

@Component({
  selector: 'app-manager-exam-vacate-pending',
  templateUrl: './manager-exam-vacate-pending.component.html',
  styleUrls: ['./manager-exam-vacate-pending.component.css']
})
export class ManagerExamVacatePendingComponent implements OnInit {
  showInfo = new PersonalInformation();
  staffId: any;
  myRecords = new SearchRecord();
  lookRecords = new Array<ExamVacatePendingRecords>();
  applyReason: string;
  approveRecords = new ManagerApproveVacateApply();
  showRecoeds(): void {
    this.examVacateService.getAllRecords(this.myRecords).subscribe(
      (data) => {
        for (let el of data) {
          let curRecord = new ExamVacatePendingRecords();
          if (el['lstatus'] === 1) {
            curRecord.applyId = el['lid'];
            curRecord.staffName = el['lstaffName'];
            curRecord.staffDepartment = el['lstaffDepartment'];
            curRecord.vacateKind = this.transKind(el['lkind']);
            curRecord.vacateStartTime = el['lstartTime'];
            curRecord.vacateEndTime = el['lendTime'];
            curRecord.reason = el['lreason'];
            this.lookRecords.push(curRecord);
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
    for (let el of this.lookRecords) {
      if (el.applyId === applyId) {
        this.applyReason = el.reason;
        alert(this.applyReason);
      }
    }
  }
  onApprove(applyId: string): void {
    for (let el of this.lookRecords) {
      if (el.applyId === applyId) {
        this.approveRecords.applyId = +applyId;
      }
    }
    this.approveRecords.checkResult = 1;
    this.approveRecords.passStaffId = this.staffId;
    console.log(this.approveRecords);
    this.examVacateService.approveApply(this.approveRecords).subscribe(
      (data) => {
        if (data['success'] === true) {
          alert('success');
          this.lookRecords = new Array<ExamVacatePendingRecords>();
          this.showRecoeds();
        } else {
          alert('error');
        }
      }
    );
  }
  onRefuse(applyId: string): void {
    for (let el of this.lookRecords) {
      if (el.applyId === applyId) {
        this.approveRecords.applyId = +applyId;
      }
    }
    this.approveRecords.checkResult = 0;
    this.approveRecords.passStaffId = this.staffId;
    console.log(this.approveRecords);
    this.examVacateService.approveApply(this.approveRecords).subscribe(
      (data) => {
        if (data['success'] === true) {
          alert('success');
          this.lookRecords = new Array<ExamVacatePendingRecords>();
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
    private examVacateService: ExamVacateService,
    private router: Router,
  ) { }

  ngOnInit() {
    this.staffId = this.LSData.getObject('staffId');
    this.myRecords.sid = this.staffId;
    this.showRecoeds();
    this.showInfo.staffId = this.LSData.getObject('staffId');
    this.showInfo.staffPosition = this.LSData.getObject('position');
    this.showInfo.staffDepartment = this.LSData.getObject('department');
  }

}
