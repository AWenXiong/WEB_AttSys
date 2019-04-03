import { TestBed } from '@angular/core/testing';

import { ExamVacateApprovedService } from './exam-vacate-approved.service';

describe('ExamVacateApprovedService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ExamVacateApprovedService = TestBed.get(ExamVacateApprovedService);
    expect(service).toBeTruthy();
  });
});
