import { Component, OnInit } from '@angular/core';
import {LocalStorage} from '../LocalStorage';
import { UpdateVacate } from 'src/app/updateVacate';
import {Router} from '@angular/router';
import {UpdataVacateService} from 'src/app/updata-vacate.service';
import {SearchRecord} from '../searchRecord';
import {WorkerSearchVacateService} from '../worker-search-vacate.service';

@Component({
  selector: 'app-update-vacate',
  templateUrl: './update-vacate.component.html',
  styleUrls: ['./update-vacate.component.css']
})
export class UpdateVacateComponent implements OnInit {

  staffId = new SearchRecord();
  myApply = new UpdateVacate();
  getApply(): void {
    this.workerSearchVacateService.getAllRecords(this.staffId).subscribe(
      (data) => {
        for (let el of data) {
          if (this.myApply.recordId === el['recordId']) {
            this.myApply.leaveKind = el['leaveKind'];
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
    this.updataVacateService.updateApply(this.myApply).subscribe(
      (data) => {
        if (data['success'] === true) {
          alert('success');
          this.router.navigateByUrl('worker/search-vacate');
        } else {
          alert('error');
        }
      }
    );
  }
  constructor(
    private LSData: LocalStorage,
    private router: Router,
    private workerSearchVacateService: WorkerSearchVacateService,
    private updataVacateService: UpdataVacateService,
  ) { }

  ngOnInit() {
    this.staffId.sid = this.LSData.getObject('staffId');
    this.myApply.recordId = this.LSData.getObject('updateVacateId');
    this.getApply();
  }

}
