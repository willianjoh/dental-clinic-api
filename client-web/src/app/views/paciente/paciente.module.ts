import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from 'src/app/shared/material/material.module';
import { SharedModule } from 'src/app/shared/shared.module';
import { PacienteComponent } from './paciente-cadastro/paciente.component';
import { PacienteRoutingModule } from './paciente-routing.module';
import { DadosPessoaisComponent } from './paciente-cadastro/dados-pessoais/dados-pessoais.component';
import { EnderecoResidencialComponent } from './paciente-cadastro/endereco-residencial/endereco-residencial.component';
@NgModule({
  imports: [
    CommonModule,
    PacienteRoutingModule,
    ReactiveFormsModule,
    SharedModule,
    MaterialModule,
  ],
  declarations: [PacienteComponent, DadosPessoaisComponent, EnderecoResidencialComponent]
})
export class PacienteModule { }
