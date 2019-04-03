import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerSearchVacateComponent } from './manager-search-vacate.component';

describe('ManagerSearchVacateComponent', () => {
  let component: ManagerSearchVacateComponent;
  let fixture: ComponentFixture<ManagerSearchVacateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerSearchVacateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerSearchVacateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
