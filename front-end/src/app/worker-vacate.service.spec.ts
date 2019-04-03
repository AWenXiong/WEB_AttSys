import { TestBed } from '@angular/core/testing';

import { WorkerVacateService } from './worker-vacate.service';

describe('WorkerVacateService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: WorkerVacateService = TestBed.get(WorkerVacateService);
    expect(service).toBeTruthy();
  });
});
