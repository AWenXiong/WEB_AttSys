import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerVacateComponent } from './manager-vacate.component';

describe('ManagerVacateComponent', () => {
  let component: ManagerVacateComponent;
  let fixture: ComponentFixture<ManagerVacateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerVacateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerVacateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
