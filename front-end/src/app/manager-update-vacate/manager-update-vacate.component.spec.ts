import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerUpdateVacateComponent } from './manager-update-vacate.component';

describe('ManagerUpdateVacateComponent', () => {
  let component: ManagerUpdateVacateComponent;
  let fixture: ComponentFixture<ManagerUpdateVacateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerUpdateVacateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerUpdateVacateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
