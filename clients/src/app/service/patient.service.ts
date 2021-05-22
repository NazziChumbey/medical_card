import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {Patient} from '../models/patient.model';
import {PatientListComponent} from "../patient-list/patient-list.component";
import {Comment} from "../models/comment.model";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class PatientService {
  patient: PatientListComponent;

  constructor(private http: HttpClient) {
  }

  private patientUrl = 'http://localhost:8080/service-api/patients';

  public getPatients() {
    return this.http.get<Patient[]>(this.patientUrl);
  }

  public deletePatient(patient) {
    return this.http.delete(this.patientUrl + '/' + patient.id);
  }

  public createPatient(patient) {
    return this.http.post<Patient>(this.patientUrl, patient);
  }

  public getPatientСomments(id) {
    return this.http.get<Comment[]>(this.patientUrl + '/' + id + '/comments');
  }

  updatePatient(patient) {
    return this.http.put(this.patientUrl + '/' + patient.id, patient);
  }

  getPatient(id: number) {
    return this.http.get<Patient>(this.patientUrl + '/' + id);
  }

  searchPatient(term: string): Observable<Patient[]> {
    if (!term.trim()) {
      return of([]);
    }
    return this.http.get<Patient[]>(this.patientUrl + '/find/' + term);
  }
}
