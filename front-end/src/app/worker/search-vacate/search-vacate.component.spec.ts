import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchVacateComponent } from './search-vacate.component';

describe('SearchVacateComponent', () => {
  let component: SearchVacateComponent;
  let fixture: ComponentFixture<SearchVacateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchVacateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchVacateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
