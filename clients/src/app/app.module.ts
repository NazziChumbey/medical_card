import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';

import {AppComponent} from './app.component';
import {PatientListComponent} from './patient-list/patient-list.component';
import {AppRoutingModule} from './app.routing.module';
import {PatientService} from './service/patient.service';
import {HttpClientModule} from '@angular/common/http';
import {CommentService} from './service/comment.service';
import {PatientDetailComponent} from "./patient-detail/patient-detail.component";
import {EditPatientComponent} from './edit-patient/edit-patient.component';
import {AddPatientComponent} from "./add-patient/add-patient.component";
import {PatientSearchComponent} from './patient-search/patient-search.component';
import {PatientCreatedNotifierService} from "./service/patient-created-notifier.service";
import {SearchPatientService} from "./service/search-patient.service";

@NgModule({
  declarations: [
    AppComponent,
    PatientListComponent,
    AddPatientComponent,
    PatientDetailComponent,
    EditPatientComponent,
    PatientSearchComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [[PatientService], [CommentService], [PatientCreatedNotifierService], [SearchPatientService]],
  bootstrap: [AppComponent]
})
export class AppModule {

}
