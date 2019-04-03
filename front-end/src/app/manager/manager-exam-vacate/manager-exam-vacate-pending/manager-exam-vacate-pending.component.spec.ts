import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerExamVacatePendingComponent } from './manager-exam-vacate-pending.component';

describe('ManagerExamVacatePendingComponent', () => {
  let component: ManagerExamVacatePendingComponent;
  let fixture: ComponentFixture<ManagerExamVacatePendingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerExamVacatePendingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerExamVacatePendingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
