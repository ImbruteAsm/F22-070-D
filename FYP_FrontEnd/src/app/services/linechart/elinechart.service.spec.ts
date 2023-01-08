import { TestBed } from '@angular/core/testing';

import { ElinechartService } from './elinechart.service';

describe('ElinechartService', () => {
  let service: ElinechartService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ElinechartService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
