package com.api.code.exception;

public class UsuarioCadastradoException extends  RuntimeException {
        public UsuarioCadastradoException(){
            super("Usuário já cadastrado com esse login." );
        }
}
