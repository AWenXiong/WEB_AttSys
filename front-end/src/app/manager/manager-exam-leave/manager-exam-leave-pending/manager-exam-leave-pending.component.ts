import { Component, OnInit } from '@angular/core';
import {ExamLeaveService} from '../../../exam-leave.service';
import { LocalStorage } from 'src/app/LocalStorage';
import {MyLeaveRecords} from 'src/app/myLeaveRecords';
import {ExamVacatePendingRecords} from 'src/app/examVacatePendingRecords';
import {forEach} from '@angular/router/src/utils/collection';
import {ManagerApproveVacateApply} from 'src/app/managerApproveVacateApply';
import {Router} from '@angular/router';
import {PersonalInformation} from 'src/app/personalInformation';
@Component({
  selector: 'app-manager-exam-leave-pending',
  templateUrl: './manager-exam-leave-pending.component.html',
  styleUrls: ['./manager-exam-leave-pending.component.css']
})
export class ManagerExamLeavePendingComponent implements OnInit {
  showInfo = new PersonalInformation();
  staffId: any;
  myRecords = new MyLeaveRecords();
  lookRecords = new Array<ExamVacatePendingRecords>();
  applyReason: string;
  approveRecords = new ManagerApproveVacateApply();
  showRecoeds(): void {
    console.log(this.myRecords);
    this.examLeaveService.getAllRecords(this.myRecords).subscribe(
      (data) => {
        console.log(data);
        for (let el of data) {
          let curRecord = new ExamVacatePendingRecords();
          if (el['ostatus'] === 1) {
            curRecord.applyId = el['oid'];
            curRecord.staffName = el['ostaffName'];
            curRecord.staffDepartment = el['ostaffDepartment'];
            curRecord.vacateStartTime = el['ostartTime'];
            curRecord.vacateEndTime = el['oendTime'];
            curRecord.reason = el['oreason'];
            this.lookRecords.push(curRecord);
          }
        }
      }
    );
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
    this.examLeaveService.approveApply(this.approveRecords).subscribe(
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
    this.examLeaveService.approveApply(this.approveRecords).subscribe(
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
    private examLeaveService: ExamLeaveService,
    private router: Router,
  ) { }

  ngOnInit() {
    this.staffId = this.LSData.getObject('staffId');
    this.myRecords.askId = this.staffId;
    this.showRecoeds();
    this.showInfo.staffId = this.LSData.getObject('staffId');
    this.showInfo.staffPosition = this.LSData.getObject('position');
    this.showInfo.staffDepartment = this.LSData.getObject('department');
  }

}
