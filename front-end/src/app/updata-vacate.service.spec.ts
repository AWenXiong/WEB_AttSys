import { TestBed } from '@angular/core/testing';

import { UpdataVacateService } from './updata-vacate.service';

describe('UpdataVacateService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UpdataVacateService = TestBed.get(UpdataVacateService);
    expect(service).toBeTruthy();
  });
});
