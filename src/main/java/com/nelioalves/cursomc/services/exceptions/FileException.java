package com.nelioalves.cursomc.services.exceptions;

//Tratamento de erros personalizado
public class FileException extends RuntimeException{
	private static final long serialVersionUID=1L;
	
	//mostra uma mensagem de erro
	public FileException(String msg) {
		super(msg);
	}
	
	//mostra mensagem e a causa deste erro
	public FileException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
