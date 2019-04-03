import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerExamVacateApprovedComponent } from './manager-exam-vacate-approved.component';

describe('ManagerExamVacateApprovedComponent', () => {
  let component: ManagerExamVacateApprovedComponent;
  let fixture: ComponentFixture<ManagerExamVacateApprovedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerExamVacateApprovedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerExamVacateApprovedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
