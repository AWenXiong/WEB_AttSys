import { Component, OnInit } from '@angular/core';
import {ExamVacateApprovedService} from '../../../exam-vacate-approved.service';
import { LocalStorage } from 'src/app/LocalStorage';
import {SearchRecord} from 'src/app/searchRecord';
import {ExamVacatePendingRecords} from 'src/app/examVacatePendingRecords';
import {Router} from '@angular/router';
import {PersonalInformation} from 'src/app/personalInformation';
@Component({
  selector: 'app-manager-exam-leave-approved',
  templateUrl: './manager-exam-leave-approved.component.html',
  styleUrls: ['./manager-exam-leave-approved.component.css']
})
export class ManagerExamLeaveApprovedComponent implements OnInit {
  showInfo = new PersonalInformation();
  staffId: any;
  myRecords = new SearchRecord();
  lookRecords = new Array<ExamVacatePendingRecords>();
  showRecoeds(): void {
    this.myRecords.sid = this.staffId;
    this.examVacateApprovedService.getApprovedLeaveRecords(this.myRecords).subscribe(
      (data) => {
        console.log(data);
        for (let el of data) {
          let curRecord = new ExamVacatePendingRecords();
          curRecord.staffId = el['ostaffId'];
          curRecord.staffName = el['ostaffName'];
          curRecord.staffDepartment = el['ostaffDepartment'];
          curRecord.vacateStartTime = el['ostartTime'];
          curRecord.vacateEndTime = el['oendTime'];
          this.lookRecords.push(curRecord);
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
    private examVacateApprovedService: ExamVacateApprovedService,
    private router: Router,
  ) { }

  ngOnInit() {
    this.staffId = this.LSData.getObject('staffId');
    this.showRecoeds();
    this.showInfo.staffId = this.LSData.getObject('staffId');
    this.showInfo.staffPosition = this.LSData.getObject('position');
    this.showInfo.staffDepartment = this.LSData.getObject('department');
  }

}
