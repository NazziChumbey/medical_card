import { TestBed } from '@angular/core/testing';

import { SearchPatient.Service.TsService } from './search-patient.service.ts.service';

describe('SearchPatient.Service.TsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SearchPatient.Service.TsService = TestBed.get(SearchPatient.Service.TsService);
    expect(service).toBeTruthy();
  });
});
