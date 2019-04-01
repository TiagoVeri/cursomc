package com.nelioalves.cursomc.services.exceptions;

//Tratamento de erros personalizado
public class AuthorizationException extends RuntimeException{
	private static final long serialVersionUID=1L;
	
	//mostra uma mensagem de erro
	public AuthorizationException(String msg) {
		super(msg);
	}
	
	//mostra mensagem e a causa deste erro
	public AuthorizationException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
