import { Injectable } from '@angular/core';
import {BehaviorSubject} from "rxjs";

@Injectable()
export class SearchPatientService{
  public subjectSearch : BehaviorSubject<string> = new BehaviorSubject("");

  constructor() { }
}
