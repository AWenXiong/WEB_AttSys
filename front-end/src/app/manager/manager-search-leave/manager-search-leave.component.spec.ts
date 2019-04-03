import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerSearchLeaveComponent } from './manager-search-leave.component';

describe('ManagerSearchLeaveComponent', () => {
  let component: ManagerSearchLeaveComponent;
  let fixture: ComponentFixture<ManagerSearchLeaveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerSearchLeaveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerSearchLeaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
