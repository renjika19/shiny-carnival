import { TestBed } from '@angular/core/testing';

import { PolkaserviceService } from './polkaservice.service';

describe('PolkaserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PolkaserviceService = TestBed.get(PolkaserviceService);
    expect(service).toBeTruthy();
  });
});
