import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { WorkerComponent } from './worker/worker.component';
import { VacateComponent } from './worker/vacate/vacate.component';
import { LeaveComponent } from './worker/leave/leave.component';
import { SearchVacateComponent } from './worker/search-vacate/search-vacate.component';
import { SearchLeaveComponent } from './worker/search-leave/search-leave.component';
import { SearchCompanyComponent } from './worker/search-company/search-company.component';
import { ManagerComponent } from './manager/manager.component';
import { ManagerVacateComponent } from './manager/manager-vacate/manager-vacate.component';
import { ManagerLeaveComponent } from './manager/manager-leave/manager-leave.component';
import { ManagerSearchVacateComponent } from './manager/manager-search-vacate/manager-search-vacate.component';
import { ManagerSearchLeaveComponent } from './manager/manager-search-leave/manager-search-leave.component';
import { ManagerSearchCompanyComponent } from './manager/manager-search-company/manager-search-company.component';
import { ManagerExamVacateComponent } from './manager/manager-exam-vacate/manager-exam-vacate.component';
import { ManagerExamVacatePendingComponent } from './manager/manager-exam-vacate/manager-exam-vacate-pending/manager-exam-vacate-pending.component';
import { ManagerExamVacateApprovedComponent } from './manager/manager-exam-vacate/manager-exam-vacate-approved/manager-exam-vacate-approved.component';
import { ManagerExamLeaveComponent } from './manager/manager-exam-leave/manager-exam-leave.component';
import { ManagerExamLeavePendingComponent } from './manager/manager-exam-leave/manager-exam-leave-pending/manager-exam-leave-pending.component';
import { ManagerExamLeaveApprovedComponent } from './manager/manager-exam-leave/manager-exam-leave-approved/manager-exam-leave-approved.component';
import { UpdateVacateComponent } from './update-vacate/update-vacate.component';
import { UpdateLeaveComponent } from './update-leave/update-leave.component';
import { ManagerUpdateVacateComponent } from './manager-update-vacate/manager-update-vacate.component';
import { ManagerUpdateLeaveComponent } from './manager-update-leave/manager-update-leave.component';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full'},
  { path: 'login', component: LoginComponent },
  { path: 'worker', component: WorkerComponent },
  { path: 'worker/vacate', component: VacateComponent },
  { path: 'worker/leave', component: LeaveComponent },
  { path: 'worker/search-vacate', component: SearchVacateComponent },
  { path: 'worker/search-leave', component: SearchLeaveComponent },
  { path: 'worker/search-company', component: SearchCompanyComponent },
  { path: 'manager', component: ManagerComponent },
  { path: 'manager/vacate', component: ManagerVacateComponent },
  { path: 'manager/leave', component: ManagerLeaveComponent },
  { path: 'manager/search-vacate', component: ManagerSearchVacateComponent },
  { path: 'manager/search-leave', component: ManagerSearchLeaveComponent },
  { path: 'manager/search-company', component: ManagerSearchCompanyComponent },
  { path: 'manager/manager-exam-vacate', component: ManagerExamVacateComponent },
  { path: 'manager/manager-exam-vacate/pending', component: ManagerExamVacatePendingComponent },
  { path: 'manager/manager-exam-vacate/approved', component: ManagerExamVacateApprovedComponent },
  { path: 'manager/manager-exam-leave', component: ManagerExamLeaveComponent },
  { path: 'manager/manager-exam-leave/pending', component: ManagerExamLeavePendingComponent },
  { path: 'manager/manager-exam-leave/approved', component: ManagerExamLeaveApprovedComponent },
  { path: 'search-vacate/update', component: UpdateVacateComponent },
  { path: 'search-leave/update', component: UpdateLeaveComponent },
  { path: 'manager-search-vacate/update', component: ManagerUpdateVacateComponent },
  { path: 'manager-search-leave/update', component: ManagerUpdateLeaveComponent },
];
@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
