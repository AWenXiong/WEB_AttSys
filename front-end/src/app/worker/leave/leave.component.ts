import { Component, OnInit } from '@angular/core';
import { OutApply } from 'src/app/outApply';
import { WorkerLeaveService } from 'src/app/worker-leave.service';
import { LocalStorage } from 'src/app/LocalStorage';
import {Router} from '@angular/router';
import {PersonalInformation} from 'src/app/personalInformation';
@Component({
  selector: 'app-leave',
  templateUrl: './leave.component.html',
  styleUrls: ['./leave.component.css']
})
export class LeaveComponent implements OnInit {
  showInfo = new PersonalInformation();
  staffId: any;
  myApply = new OutApply();

  wrtieApply(): void {
    this.myApply.staffId = this.staffId;
    console.log(this.myApply.staffId);
    console.log(this.myApply.startTime);
    console.log(this.myApply.endTime);
    console.log(this.myApply.reason);
    this.workerLeaveService.addLeaveApply(this.myApply).subscribe(
      (data) => {
        if (data['success'] === true ) {
          alert('success');
          this.myApply = new OutApply();
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
    private workerLeaveService: WorkerLeaveService,
    private router: Router,
  ) { }

  ngOnInit() {
    this.staffId = this.LSData.getObject('staffId');
    this.showInfo.staffId = this.LSData.getObject('staffId');
    this.showInfo.staffPosition = this.LSData.getObject('position');
    this.showInfo.staffDepartment = this.LSData.getObject('department');
  }

}
