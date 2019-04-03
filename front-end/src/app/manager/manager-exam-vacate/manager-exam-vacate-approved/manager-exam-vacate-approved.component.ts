import { Component, OnInit } from '@angular/core';
import {ExamVacateApprovedService} from '../../../exam-vacate-approved.service';
import { LocalStorage } from 'src/app/LocalStorage';
import {SearchRecord} from 'src/app/searchRecord';
import {ExamVacatePendingRecords} from 'src/app/examVacatePendingRecords';
import {Router} from '@angular/router';
import {PersonalInformation} from 'src/app/personalInformation';
@Component({
  selector: 'app-manager-exam-vacate-approved',
  templateUrl: './manager-exam-vacate-approved.component.html',
  styleUrls: ['./manager-exam-vacate-approved.component.css']
})
export class ManagerExamVacateApprovedComponent implements OnInit {
  showInfo = new PersonalInformation();
  staffId: any;
  myRecords = new SearchRecord();
  lookRecords = new Array<ExamVacatePendingRecords>();
  showRecoeds(): void {
    this.myRecords.sid = this.staffId;
    this.examVacateApprovedService.getApprovedRecords(this.myRecords).subscribe(
      (data) => {
        console.log(data);
        for (let el of data) {
          let curRecord = new ExamVacatePendingRecords();
          curRecord.staffId = el['lstaffId'];
          curRecord.staffName = el['lstaffName'];
          curRecord.staffDepartment = el['lstaffDepartment'];
          curRecord.vacateKind = this.transKind(el['lkind']);
          curRecord.vacateStartTime = el['lstartTime'];
          curRecord.vacateEndTime = el['lendTime'];
          this.lookRecords.push(curRecord);
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
