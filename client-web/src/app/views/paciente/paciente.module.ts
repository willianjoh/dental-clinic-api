import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from 'src/app/shared/shared.module';
import { PacienteComponent } from './paciente-cadastro/paciente.component';
import { PacienteRoutingModule } from './paciente-routing.module';

@NgModule({
  imports: [
    CommonModule,
    PacienteRoutingModule,
    ReactiveFormsModule,
    SharedModule
  ],
  declarations: [PacienteComponent]
})
export class PacienteModule { }
