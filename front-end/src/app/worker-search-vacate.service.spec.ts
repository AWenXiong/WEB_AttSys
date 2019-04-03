import { TestBed } from '@angular/core/testing';

import { WorkerSearchVacateService } from './worker-search-vacate.service';

describe('WorkerSearchVacateService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: WorkerSearchVacateService = TestBed.get(WorkerSearchVacateService);
    expect(service).toBeTruthy();
  });
});
