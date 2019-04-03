import { Component, OnInit } from '@angular/core';
import {WorkerSearchLeaveService} from '../../worker-search-leave.service';
import { LocalStorage } from 'src/app/LocalStorage';
import {SearchRecord} from '../../searchRecord';
import {forEach} from '@angular/router/src/utils/collection';
import {LeaveRecords} from '../../leaveRecords';
import {Router} from '@angular/router';
import {DeleteLeaveRecord} from '../../deleteLeaveRecord';
import {PersonalInformation} from 'src/app/personalInformation';
@Component({
  selector: 'app-manager-search-leave',
  templateUrl: './manager-search-leave.component.html',
  styleUrls: ['./manager-search-leave.component.css']
})
export class ManagerSearchLeaveComponent implements OnInit {
  showInfo = new PersonalInformation();
  staffId: any;
  myRecords = new SearchRecord();
  deleteId = new DeleteLeaveRecord();
  pendingRecords = new Array<LeaveRecords>();
  refusedRecords = new Array<LeaveRecords>();
  approvedRecords = new Array<LeaveRecords>();
  recordReason: string;
  showRecoeds(): void {
    this.myRecords.sid = this.staffId;
    this.workerSearchLeaveService.getAllRecords(this.myRecords).subscribe(
      (data) => {
        console.log(data);
        for (let el of data) {
          let curRecord = new LeaveRecords();
          if (el['status'] === 'PASSED') {
            curRecord.applyId = el['recordId'];
            curRecord.startTime = el['startTime'];
            curRecord.endTime = el['endTime'];
            curRecord.sir = el['passStaffName'];
            curRecord.reason = el['reason'];
            this.approvedRecords.push(curRecord);
          } else if (el['status'] === 'REJECTED') {
            curRecord.applyId = el['recordId'];
            curRecord.startTime = el['startTime'];
            curRecord.endTime = el['endTime'];
            curRecord.sir = el['passStaffName'];
            curRecord.reason = el['reason'];
            this.refusedRecords.push(curRecord);
          } else if (el['status'] === 'PENDING') {
            curRecord.applyId = el['recordId'];
            curRecord.startTime = el['startTime'];
            curRecord.endTime = el['endTime'];
            curRecord.reason = el['reason'];
            this.pendingRecords.push(curRecord);
          }
        }
      }
    );
  }
  onLook(applyId: string): void {
    this.myRecords.sid = this.staffId;
    this.workerSearchLeaveService.getAllRecords(this.myRecords).subscribe(
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
    this.LSData.setObject('updateManagerLeaveId', applyId);
    this.router.navigateByUrl('/manager-search-leave/update');
  }
  onDelete(applyId: string): void {
    this.deleteId.recordId = applyId;
    this.workerSearchLeaveService.deleteRecords(this.deleteId).subscribe(
      (data) => {
        if (data['success'] === true) {
          alert('success');
          this.pendingRecords = new Array<LeaveRecords>();
          this.refusedRecords = new Array<LeaveRecords>();
          this.approvedRecords = new Array<LeaveRecords>();
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
    private workerSearchLeaveService: WorkerSearchLeaveService,
  ) { }

  ngOnInit() {
    this.staffId = this.LSData.getObject('staffId');
    this.showRecoeds();
    this.showInfo.staffId = this.LSData.getObject('staffId');
    this.showInfo.staffPosition = this.LSData.getObject('position');
    this.showInfo.staffDepartment = this.LSData.getObject('department');
  }
}
