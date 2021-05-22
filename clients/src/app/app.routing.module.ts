import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {PatientListComponent} from './patient-list/patient-list.component';
import {AddPatientComponent} from './add-patient/add-patient.component';
import {PatientDetailComponent} from "./patient-detail/patient-detail.component";
import {EditPatientComponent} from "./edit-patient/edit-patient.component";

const routes: Routes = [
  {path: '', redirectTo: '/patient/1', pathMatch: 'full'},
  {path: 'patient/:id', component: PatientDetailComponent},
  {path: 'patients', component: PatientListComponent},
  {path: 'create-patient', component: AddPatientComponent},
  {path: 'edit-patient/:id', component: EditPatientComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule {
}
