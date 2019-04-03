import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { Login } from '../login';
import { Router } from '@angular/router';
import { LocalStorage } from 'src/app/LocalStorage';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  myUser = new Login();
  getId: string;
  getPosition: string;
  getDepartment: string;
  constructor(
    private LSData: LocalStorage,
    private router: Router,
    private loginService: LoginService,
  ) { }

  ngOnInit() {
  }

  login(): void {
    this.loginService.login(this.myUser).subscribe(
      (data) => {
        this.getId = data['staffId'];
        this.getPosition = data['staffPosition'];
        this.getDepartment = data['staffDepartment'];
        if (this.getId != null && this.getPosition != null && this.getDepartment != null) {
          this.LSData.setObject('staffId', data['staffId']);
          this.LSData.setObject('annualVacateDays', data['staffSalaryHoliday']);
          this.LSData.setObject('position', data['staffPosition']);
          this.LSData.setObject('department', data['staffDepartment']);
          if (this.getPosition === '普通员工') {
            if (this.getDepartment === '财务部') {
              this.router.navigateByUrl('/accountant');
            } else {
              this.router.navigateByUrl('/worker');
            }
          } else if (this.getPosition === '总经理' || this.getPosition === '副总经理') {
            this.router.navigateByUrl('/manager');
          }
        } else {
        }
      });
}
}

