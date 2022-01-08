import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';
import { TabsModule } from 'ngx-bootstrap/tabs';
import { IConfig, NgxMaskModule } from 'ngx-mask';
import { SharedModule } from 'src/app/shared/shared.module';
import { PacienteComponent } from './paciente-cadastro/paciente.component';
import { PacienteRoutingModule } from './paciente-routing.module';

const maskConfig: Partial<IConfig> = {
  validation: false,
};

@NgModule({
  imports: [
    CommonModule,
    PacienteRoutingModule,
    ReactiveFormsModule,
    SharedModule,
  ],
  declarations: [PacienteComponent]
})
export class PacienteModule { }
