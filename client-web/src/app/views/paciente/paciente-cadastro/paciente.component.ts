import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-paciente',
  templateUrl: './paciente.component.html',
  styleUrls: ['./paciente.component.scss']
})
export class PacienteComponent implements OnInit {

  formulario!: FormGroup;

  constructor() {}

  ngOnInit() {
    this.formulario = new FormGroup({
      nome: new FormControl(null, [Validators.required]),
      sobrenome: new FormControl(null, [Validators.required]),
      email: new FormControl(null, [Validators.required]),
      dataNascimento: new FormControl(null, [Validators.required])
    })
  }

}
