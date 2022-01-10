import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { BsLocaleService } from 'ngx-bootstrap/datepicker';
import { Generos } from 'src/app/models/common-models/generos.interface';
import { CommonUtils } from '../../../util/common-utils';

@Component({
  selector: 'app-paciente',
  templateUrl: './paciente.component.html',
  styleUrls: ['./paciente.component.scss']
})
export class PacienteComponent implements OnInit {

  dadosPessoaisForm!: FormGroup;
  enderecoForm!: FormGroup;
  informacoesForm!: FormGroup;
  generos: Generos[] = [];
  isValid!: boolean;
  constructor(private bsLocaleService: BsLocaleService,
    private formBuilder: FormBuilder) {
    this.bsLocaleService.use('pt-br');

  }

  ngOnInit() {
    this.buildFormGroup();
    this.getGeneros();
  }

    buildFormGroup(){
      this.dadosPessoaisForm = this.formBuilder.group({
        nome: ['', Validators.required],
        email: ['', Validators.required],
        cpf: ['', Validators.required],
        dataNascimento: ['', Validators.required],
        contato: ['', Validators.required],
        genero: ['', Validators.required],
        rg: [''],
        contatoFixo: [''],
        maiorIdade: [''],
      });

      this.enderecoForm = this.formBuilder.group({
        secondCtrl: ['', Validators.required],
      });

      this.informacoesForm = this.formBuilder.group({
        info: [''],
      });

    }
  getGeneros() {
    this.generos = [
      { value: 1, descricao: 'Masculino' },
      { value: 2, descricao: 'Feminino' }
    ];
  }

  isValidated(formulario: FormGroup, field: string) {
    return formulario.get(field)?.invalid && (formulario.get(field)?.dirty || formulario.get(field)?.touched);
  }

  nextTabValidation(){
     if(!this.dadosPessoaisForm.valid){
       console.log(this.dadosPessoaisForm)
       console.log("Status" + this.dadosPessoaisForm.status)

       CommonUtils.validateAllFields(this.dadosPessoaisForm);
       this.isValid = false;
      } else {
        this.isValid = !this.isValid;
        console.log(this.dadosPessoaisForm)
        console.log("Status" + this.dadosPessoaisForm.status)
      }
  }

  salvar(){
    if(!this.dadosPessoaisForm.valid || !this.enderecoForm.valid){
      CommonUtils.validateAllFields(this.dadosPessoaisForm);
    }
  }
}
