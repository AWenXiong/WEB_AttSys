import { TestBed } from '@angular/core/testing';

import { ExamVacateService } from './exam-vacate.service';

describe('ExamVacateService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ExamVacateService = TestBed.get(ExamVacateService);
    expect(service).toBeTruthy();
  });
});
