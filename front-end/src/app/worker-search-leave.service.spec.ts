import { TestBed } from '@angular/core/testing';

import { WorkerSearchLeaveService } from './worker-search-leave.service';

describe('WorkerSearchLeaveService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: WorkerSearchLeaveService = TestBed.get(WorkerSearchLeaveService);
    expect(service).toBeTruthy();
  });
});
