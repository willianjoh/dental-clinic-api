import { LOCALE_ID, NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './template/home/home.component';
import { TemplateModule } from './template/template.module';
import { PacienteModule } from './views/paciente/paciente.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './shared/material/material.module';
import { DateAdapter, MAT_DATE_LOCALE, MAT_DATE_FORMATS } from '@angular/material/core';
import { MomentDateAdapter } from '@angular/material-moment-adapter';



export const DateFormat = {
  parse: {
    dateInput: 'input',
  },
  display: {
    dateInput: 'MM/DD/YYYY',
    monthYearLabel: 'MMMM YYYY',
    dateA11yLabel: 'MM/DD/YYYY',
    monthYearA11yLabel: 'MMMM YYYY',
  }
};

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    PacienteModule,
    TemplateModule,
    BrowserAnimationsModule,
    MaterialModule,
  ],

  providers: [
    { provide: MAT_DATE_LOCALE, useValue: 'pt-BR' },
  ],

  bootstrap: [AppComponent]
})
export class AppModule {

}
