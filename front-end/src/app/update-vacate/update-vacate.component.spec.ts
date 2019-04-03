import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateVacateComponent } from './update-vacate.component';

describe('UpdateVacateComponent', () => {
  let component: UpdateVacateComponent;
  let fixture: ComponentFixture<UpdateVacateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateVacateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateVacateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
