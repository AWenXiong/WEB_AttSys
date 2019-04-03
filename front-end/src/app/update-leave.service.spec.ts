import { TestBed } from '@angular/core/testing';

import { UpdateLeaveService } from './update-leave.service';

describe('UpdateLeaveService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UpdateLeaveService = TestBed.get(UpdateLeaveService);
    expect(service).toBeTruthy();
  });
});
