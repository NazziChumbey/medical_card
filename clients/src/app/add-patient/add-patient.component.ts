import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { Patient } from '../models/patient.model';
import { PatientService} from "../service/patient.service";
import {PatientCreatedNotifierService} from "../service/patient-created-notifier.service";

@Component({
  selector: 'add-patient',
  templateUrl: './add-patient.component.html',
  styleUrls: ['./add-patient.component.css']
})
export class AddPatientComponent {

  patient: Patient = new Patient();

  constructor(private router: Router, private patientService: PatientService, private patientNotifier: PatientCreatedNotifierService) {
  }

  createPatient(): void {
    this.patientService.createPatient(this.patient)
      .subscribe( data => {
        this.patient.firstName = "";
        this.patient.lastName = "";
        this.patient.dateOfBirth = new Date();
        this.patient.sex = "";
        this.patient.country = "";
        this.patient.state = "";
        this.patient.address = "";
        this.patientNotifier.subject.next("patient Created")
      });
  }
}
