import { TestBed } from '@angular/core/testing';

import { PatientCreatedNotifierService } from './patient-created-notifier.service';

describe('PatientCreatedNotifierService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PatientCreatedNotifierService = TestBed.get(PatientCreatedNotifierService);
    expect(service).toBeTruthy();
  });
});
