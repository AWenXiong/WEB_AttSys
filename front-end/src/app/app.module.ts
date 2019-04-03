import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; // <-- NgModel lives here
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { WorkerComponent } from './worker/worker.component';
import { VacateComponent } from './worker/vacate/vacate.component';
import { LeaveComponent } from './worker/leave/leave.component';
import { SearchVacateComponent } from './worker/search-vacate/search-vacate.component';
import { SearchLeaveComponent } from './worker/search-leave/search-leave.component';
import { AppRoutingModule } from './app-routing.module';
import { SearchCompanyComponent } from './worker/search-company/search-company.component';
import { ManagerComponent } from './manager/manager.component';
import { ManagerVacateComponent } from './manager/manager-vacate/manager-vacate.component';
import { ManagerLeaveComponent } from './manager/manager-leave/manager-leave.component';
import { ManagerSearchVacateComponent } from './manager/manager-search-vacate/manager-search-vacate.component';
import { ManagerSearchLeaveComponent } from './manager/manager-search-leave/manager-search-leave.component';
import { ManagerSearchCompanyComponent } from './manager/manager-search-company/manager-search-company.component';
import { ManagerExamVacateComponent } from './manager/manager-exam-vacate/manager-exam-vacate.component';
import { ManagerExamLeaveComponent } from './manager/manager-exam-leave/manager-exam-leave.component';
import { ManagerExamVacatePendingComponent } from './manager/manager-exam-vacate/manager-exam-vacate-pending/manager-exam-vacate-pending.component';
import { ManagerExamVacateApprovedComponent } from './manager/manager-exam-vacate/manager-exam-vacate-approved/manager-exam-vacate-approved.component';
import { ManagerExamLeaveApprovedComponent } from './manager/manager-exam-leave/manager-exam-leave-approved/manager-exam-leave-approved.component';
import { ManagerExamLeavePendingComponent } from './manager/manager-exam-leave/manager-exam-leave-pending/manager-exam-leave-pending.component';
import { HttpClientModule } from '@angular/common/http';
import { LocalStorage } from 'src/app/LocalStorage';
import { UpdateVacateComponent } from './update-vacate/update-vacate.component';
import { UpdateLeaveComponent } from './update-leave/update-leave.component';
import { ManagerUpdateVacateComponent } from './manager-update-vacate/manager-update-vacate.component';
import { ManagerUpdateLeaveComponent } from './manager-update-leave/manager-update-leave.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    WorkerComponent,
    VacateComponent,
    LeaveComponent,
    SearchVacateComponent,
    SearchLeaveComponent,
    SearchCompanyComponent,
    ManagerComponent,
    ManagerVacateComponent,
    ManagerLeaveComponent,
    ManagerSearchVacateComponent,
    ManagerSearchLeaveComponent,
    ManagerSearchCompanyComponent,
    ManagerExamVacateComponent,
    ManagerExamLeaveComponent,
    ManagerExamVacatePendingComponent,
    ManagerExamVacateApprovedComponent,
    ManagerExamLeaveApprovedComponent,
    ManagerExamLeavePendingComponent,
    UpdateVacateComponent,
    UpdateLeaveComponent,
    ManagerUpdateVacateComponent,
    ManagerUpdateLeaveComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    LocalStorage,
  ],
  bootstrap: [AppComponent,
    /*NzDemoModalAsyncComponent*/
  ]
})
export class AppModule { }
