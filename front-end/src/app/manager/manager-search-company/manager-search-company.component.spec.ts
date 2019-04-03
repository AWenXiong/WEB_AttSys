import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerSearchCompanyComponent } from './manager-search-company.component';

describe('ManagerSearchCompanyComponent', () => {
  let component: ManagerSearchCompanyComponent;
  let fixture: ComponentFixture<ManagerSearchCompanyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerSearchCompanyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerSearchCompanyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
