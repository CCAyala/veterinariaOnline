import { TestBed } from '@angular/core/testing';

import { PlanMejoramientoService } from './plan-mejoramiento.service';

describe('PlanMejoramientoService', () => {
  let service: PlanMejoramientoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PlanMejoramientoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
