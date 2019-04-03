import { Component, OnInit } from '@angular/core';
import { LeaveApply } from 'src/app/leaveApply';
import { WorkerVacateService } from 'src/app/worker-vacate.service';
import { LocalStorage } from 'src/app/LocalStorage';
import {PersonalInformation} from 'src/app/personalInformation';
import {Router} from '@angular/router';

@Component({
  selector: 'app-vacate',
  templateUrl: './vacate.component.html',
  styleUrls: ['./vacate.component.css']
})
export class VacateComponent implements OnInit {
  showInfo = new PersonalInformation();
  days: string;
  annualVacateDays: number;
  staffId: any;
  myApply = new LeaveApply();
  wrtieApply(): void {
    this.myApply.staffId = this.staffId;
    this.workerVacateService.addVacateApply(this.myApply).subscribe(
      (data) => {
        if (data['success'] === true ) {
          alert('success');
          this.myApply = new LeaveApply();
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
    private workerVacateService: WorkerVacateService,
    private router: Router,
  ) { }

  ngOnInit() {
    this.staffId = this.LSData.getObject('staffId');
    this.annualVacateDays = this.LSData.getObject('annualVacateDays');
    this.days = this.annualVacateDays + '天';
    this.showInfo.staffId = this.LSData.getObject('staffId');
    this.showInfo.staffPosition = this.LSData.getObject('position');
    this.showInfo.staffDepartment = this.LSData.getObject('department');
    console.log(this.showInfo.staffId);
    console.log(this.showInfo.staffPosition);
    console.log(this.showInfo.staffDepartment);
  }

}
