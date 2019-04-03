import { Component, OnInit } from '@angular/core';
import {SearchCompanyService} from '../../search-company.service';
import {WorkerSearchCompany} from 'src/app/workerSearchCompany';
import {SearchCompanyResult} from '../../searchCompanyResult';
import {forEach} from '@angular/router/src/utils/collection';
import { LocalStorage } from 'src/app/LocalStorage';
import {Router} from '@angular/router';
import {PersonalInformation} from 'src/app/personalInformation';
@Component({
  selector: 'app-manager-search-company',
  templateUrl: './manager-search-company.component.html',
  styleUrls: ['./manager-search-company.component.css']
})
export class ManagerSearchCompanyComponent implements OnInit {
  showInfo = new PersonalInformation();
  condition = new WorkerSearchCompany();
  myResults = new Array<SearchCompanyResult>();
  onClick(): void {
    this.searchCompanyService.getResult(this.condition).subscribe(
      (data) => {
        console.log(data);
        for (let el of data) {
          let curResult = new SearchCompanyResult();
          curResult.staffName = el['infoName'];
          curResult.staffDepartment = el['infoDepartment'];
          curResult.startTime = el['infoStartTime'];
          curResult.endTime = el['infoEndTime'];
          this.myResults.push(curResult);
        }
      }
    );
    this.myResults = new Array<SearchCompanyResult>();
  }
  exit(): void {
    this.LSData.removeAll();
    this.router.navigateByUrl('/login');
  }
  constructor(
    private LSData: LocalStorage,
    private router: Router,
    private searchCompanyService: SearchCompanyService,
  ) { }

  ngOnInit() {
    this.showInfo.staffId = this.LSData.getObject('staffId');
    this.showInfo.staffPosition = this.LSData.getObject('position');
    this.showInfo.staffDepartment = this.LSData.getObject('department');
  }

}
