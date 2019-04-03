import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerExamVacateComponent } from './manager-exam-vacate.component';

describe('ManagerExamVacateComponent', () => {
  let component: ManagerExamVacateComponent;
  let fixture: ComponentFixture<ManagerExamVacateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerExamVacateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerExamVacateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
