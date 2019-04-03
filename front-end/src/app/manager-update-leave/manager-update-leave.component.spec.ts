import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerUpdateLeaveComponent } from './manager-update-leave.component';

describe('ManagerUpdateLeaveComponent', () => {
  let component: ManagerUpdateLeaveComponent;
  let fixture: ComponentFixture<ManagerUpdateLeaveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerUpdateLeaveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerUpdateLeaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
