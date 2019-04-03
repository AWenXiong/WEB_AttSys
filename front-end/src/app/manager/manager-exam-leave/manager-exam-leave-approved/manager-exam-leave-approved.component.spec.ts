import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerExamLeaveApprovedComponent } from './manager-exam-leave-approved.component';

describe('ManagerExamLeaveApprovedComponent', () => {
  let component: ManagerExamLeaveApprovedComponent;
  let fixture: ComponentFixture<ManagerExamLeaveApprovedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerExamLeaveApprovedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerExamLeaveApprovedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
