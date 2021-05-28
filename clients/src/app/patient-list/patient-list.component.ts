import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

import {Patient} from '../models/patient.model';
import {PatientService} from '../service/patient.service';
import {PatientCreatedNotifierService} from "../service/patient-created-notifier.service";
import {SearchPatientService} from "../service/search-patient.service";
import {Subject} from "rxjs";
import {debounceTime, distinctUntilChanged, switchMap} from "rxjs/operators";

@Component({
  selector: 'patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.css']
})
export class PatientListComponent implements OnInit {
  patients: Patient[];

  private searchTerms = new Subject<string>();

  constructor(private route: Router,
              private patientService: PatientService,
              private patientNotified: PatientCreatedNotifierService,
              private patientSearchService: SearchPatientService) {
  }

  ngOnInit() {
    this.patientNotified.subject.subscribe(value => {
      this.loadPatient();
    });


    this.patientSearchService.subjectSearch.subscribe(value => {
      this.searchTerms.next(value);

      this.searchTerms.pipe(
        debounceTime(300),
        distinctUntilChanged(),
        switchMap((term: string) => this.patientService.searchPatient(term)),
      ).subscribe(patients => {
        if (patients.length != 0){
          this.patients = patients;
        }else{
          this.loadPatient();
        }
      });
      this.loadPatient();
    });
    this.loadPatient();
  }

  private loadPatient() {
    this.patientService.getPatients()
      .subscribe(data => {
        this.patients = data;
      });
  }
}
