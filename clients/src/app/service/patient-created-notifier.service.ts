import { Injectable } from '@angular/core';
import {BehaviorSubject} from "rxjs";

@Injectable()
export class PatientCreatedNotifierService {

  constructor() { }

  public subject:BehaviorSubject<string> = new BehaviorSubject("");
}
