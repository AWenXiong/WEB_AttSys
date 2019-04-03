import { TestBed } from '@angular/core/testing';

import { ExamLeaveService } from './exam-leave.service';

describe('ExamLeaveService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ExamLeaveService = TestBed.get(ExamLeaveService);
    expect(service).toBeTruthy();
  });
});
