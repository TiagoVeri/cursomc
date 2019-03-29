package com.nelioalves.cursomc.services.exceptions;

//Tratamento de erros personalizado
public class DataIntegrityException extends RuntimeException{
	private static final long serialVersionUID=1L;
	
	//mostra uma mensagem de erro
	public DataIntegrityException(String msg) {
		super(msg);
	}
	
	//mostra mensagem e a causa deste erro
	public DataIntegrityException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
