import { TestBed } from '@angular/core/testing';

import { DettaglioService } from './dettaglio.service';

describe('DettaglioService', () => {
  let service: DettaglioService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DettaglioService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
