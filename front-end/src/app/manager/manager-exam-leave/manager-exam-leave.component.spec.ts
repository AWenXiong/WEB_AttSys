import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerExamLeaveComponent } from './manager-exam-leave.component';

describe('ManagerExamLeaveComponent', () => {
  let component: ManagerExamLeaveComponent;
  let fixture: ComponentFixture<ManagerExamLeaveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerExamLeaveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerExamLeaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
