import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerExamLeavePendingComponent } from './manager-exam-leave-pending.component';

describe('ManagerExamLeavePendingComponent', () => {
  let component: ManagerExamLeavePendingComponent;
  let fixture: ComponentFixture<ManagerExamLeavePendingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerExamLeavePendingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerExamLeavePendingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
