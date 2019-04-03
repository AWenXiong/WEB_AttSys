import { TestBed } from '@angular/core/testing';

import { WorkerLeaveService } from './worker-leave.service';

describe('WorkerLeaveService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: WorkerLeaveService = TestBed.get(WorkerLeaveService);
    expect(service).toBeTruthy();
  });
});
