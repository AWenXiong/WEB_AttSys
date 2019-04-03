import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchLeaveComponent } from './search-leave.component';

describe('SearchLeaveComponent', () => {
  let component: SearchLeaveComponent;
  let fixture: ComponentFixture<SearchLeaveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchLeaveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchLeaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
