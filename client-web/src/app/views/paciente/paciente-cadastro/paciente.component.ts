import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { BsLocaleService } from 'ngx-bootstrap/datepicker';
import { BreadcrumbItem } from '../../../models/common/breadcrumb-item.interface';

@Component({
  selector: 'app-paciente',
  templateUrl: './paciente.component.html',
  styleUrls: ['./paciente.component.scss']
})
export class PacienteComponent implements OnInit {

  breadcrumb: BreadcrumbItem[] = [];
  formulario!: FormGroup;
  endereco!: FormGroup;
  active = 1;

  constructor(private bsLocaleService: BsLocaleService) {
    this.breadcrumb = [
      { title: 'Início', active: false },
      { title: 'Pacientes', active: false },
      { title: 'Cadastrar', active: true },
    ]
    this.bsLocaleService.use('pt-br');

  }

  ngOnInit() {
    this.formulario = new FormGroup({
      nome: new FormControl(null, [Validators.required]),
      email: new FormControl(null, [Validators.required]),
      cpf: new FormControl(null, [Validators.required]),
      rg: new FormControl(null),
      contato: new FormControl(null, [Validators.required]),
      contatoFixo: new FormControl(null),
      genero: new FormControl(null, [Validators.required]),
      dataNascimento: new FormControl(null, [Validators.required]),
    })

    this.endereco = new FormGroup({
      cep: new FormControl(null, [Validators.required]),
    })

  }

}
