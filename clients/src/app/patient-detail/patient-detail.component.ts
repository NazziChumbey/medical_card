import {Component, OnInit, Input, OnDestroy, ViewChild} from '@angular/core';
import {PatientService} from "../service/patient.service";
import {Patient} from "../models/patient.model";
import {Comment} from "../models/comment.model";

import {ActivatedRoute} from '@angular/router';
import {Location} from '@angular/common';
import {CommentService} from "../service/comment.service";
import {PatientListComponent} from '../patient-list/patient-list.component';
import {PatientCreatedNotifierService} from '../service/patient-created-notifier.service';

@Component({
  selector: 'app-patient-detail',
  templateUrl: './patient-detail.component.html',
  styleUrls: ['./patient-detail.component.css']
})
export class PatientDetailComponent implements OnInit {

  selectedPatient: Patient;
  comments: Comment[];
  patients: Patient[];
  comment_create: Comment = new Comment();
  idPatient: number;
  public age: number;
  @ViewChild(PatientListComponent) patientListComponent: PatientListComponent;

  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private patientService: PatientService,
    private commentService: CommentService,
    private patientNotifier: PatientCreatedNotifierService) {
  }

  ngOnInit() {
    this.route.params.subscribe(value => {
      this.idPatient = value.id;
      this.getPatient(value.id);
    });
  }


  getPatient(id: number): void {
    this.patientService.getPatient(id)
      .subscribe(patient => {
        this.selectedPatient = patient;
        this.getPatientСomments(id);
        this.сalculateAge(id);
      });
    this.patientService.getPatients().subscribe(patients => {
      this.patients = patients;
    })
  }

  сalculateAge(id: number): void {
    this.patientService.getPatient(id).subscribe(value => {
      var timeDiff = Math.abs(Date.now() - new Date(value.dateOfBirth).getTime());
      this.age = Math.floor((timeDiff / (1000 * 3600 * 24))/365);
    });
  }

  deletePatient(patient: Patient): void {
    this.patientService.deletePatient(patient)
      .subscribe(data => {
        this.patients = this.patients.filter(p => p !== patient);
        this.patientNotifier.subject.next("patient Delete");

        alert("Patient delete");
        this.location.back();
      });

  }

  getPatientСomments(id: number): void {
    this.patientService.getPatientСomments(id).subscribe(data => {
      this.comments = data;
    });
  }

  createComment(): void {
    this.commentService.createComment(this.comment_create, this.idPatient)
      .subscribe(data => {
        this.getPatientСomments(this.idPatient);
        this.comment_create.comment = "";
      });
  }
}
