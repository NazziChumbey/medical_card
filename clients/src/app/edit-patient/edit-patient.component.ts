import {Component, OnInit} from '@angular/core';
import {PatientService} from "../service/patient.service";
import {Patient} from "../models/patient.model";
import {ActivatedRoute} from "@angular/router";
import {Location} from "@angular/common";
import {PatientCreatedNotifierService} from "../service/patient-created-notifier.service";

@Component({
  selector: 'app-edit-patient',
  templateUrl: './edit-patient.component.html',
  styleUrls: ['./edit-patient.component.css']
})
export class EditPatientComponent implements OnInit {
  change_patient: Patient;

  constructor(private route: ActivatedRoute,
              private location: Location,
              private patientService: PatientService,
              private patientNotifier: PatientCreatedNotifierService) {
  }

  ngOnInit() {
    this.getPatient();
  }

  getPatient(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.patientService.getPatient(id).subscribe(patient => {
        this.change_patient = patient;
      });
  }

  updatePatient(patient: Patient): void {
    this.patientService.updatePatient(patient).subscribe(value => {
      this.patientNotifier.subject.next("patient Edited");
      this.location.back();
    });
  }

}
