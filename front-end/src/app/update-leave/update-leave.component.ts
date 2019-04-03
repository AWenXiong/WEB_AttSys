import { Component, OnInit } from '@angular/core';
import { UpdateLeave } from 'src/app/updateLeave';
import {Router} from '@angular/router';
import {LocalStorage} from '../LocalStorage';
import {WorkerSearchLeaveService} from '../worker-search-leave.service';
import {SearchRecord} from '../searchRecord';
import {UpdateLeaveService} from 'src/app/update-leave.service';
@Component({
  selector: 'app-update-leave',
  templateUrl: './update-leave.component.html',
  styleUrls: ['./update-leave.component.css']
})
export class UpdateLeaveComponent implements OnInit {
  staffId = new SearchRecord();
  myApply = new UpdateLeave();
  getApply(): void {
    this.workerSearchLeaveService.getAllRecords(this.staffId).subscribe(
      (data) => {
        for (let el of data) {
          if (this.myApply.recordId === el['recordId']) {
            this.myApply.startTime = this.transTime(el['startTime']);
            this.myApply.endTime = this.transTime(el['endTime']);
            this.myApply.reason = el['reason'];
          }
        }
      }
    );
  }
  transTime(time: string) {
    return time.substring(0, 10);
  }
  update(): void {
    this.updateLeaveService.updateApply(this.myApply).subscribe(
      (data) => {
        if (data['success'] === true) {
          alert('success');
          this.router.navigateByUrl('worker/search-leave');
        } else {
          alert('error');
        }
      }
    );
  }
  constructor(
    private LSData: LocalStorage,
    private router: Router,
    private workerSearchLeaveService: WorkerSearchLeaveService,
    private updateLeaveService: UpdateLeaveService,
  ) { }

  ngOnInit() {
    this.staffId.sid = this.LSData.getObject('staffId');
    this.myApply.recordId = this.LSData.getObject('updateLeaveId');
    this.getApply();
  }

}
