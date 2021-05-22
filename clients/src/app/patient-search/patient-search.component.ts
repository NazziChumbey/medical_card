import {Component, OnInit} from '@angular/core';
import {PatientService} from "../service/patient.service";
import {Location} from "@angular/common";
import {SearchPatientService} from "../service/search-patient.service";

@Component({
  selector: 'patient-search',
  templateUrl: './patient-search.component.html',
  styleUrls: ['./patient-search.component.css']
})
export class PatientSearchComponent implements OnInit {

  constructor(
    private location: Location,
    private patientService: PatientService,
    private patientSearchService: SearchPatientService) {
  }

  search(term: string): any {
    this.patientSearchService.subjectSearch.next(term);
  }

  ngOnInit(): void {
  }

  goBack(): void {
    this.location.back();
  }
}
