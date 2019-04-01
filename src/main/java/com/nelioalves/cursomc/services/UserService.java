package com.nelioalves.cursomc.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.nelioalves.cursomc.security.UserSS;

//classe para retornar user logado
public class UserService {

	
	//Para obter o usuário logado na forma de usuário Spring Security (UserSS) é utilizado o casting 
	//de USERSS e SecurityContextHolder
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch(Exception e) {
			return null;
			
		}
	}
}
