package com.nelioalves.cursomc.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.repository.ClienteRepository;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;

//Serviços baseados em autentificação, "esqueci a senha" e outros
@Service 
public class AuthService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private EmailService emailService;
	
	private Random rand = new Random();
	
	//verifica se o email existe a partir de um clienteRepository
	public void sendNewPassword(String email) {
		
		Cliente cliente = clienteRepository.findByEmail(email);
		if(cliente == null) {
			throw new ObjectNotFoundException("Email não encontrado");
		}
		
		String newPass = newPassword();
		cliente.setSenha(pe.encode(newPass));
		
		clienteRepository.save(cliente);
		emailService.sendNewPasswordEmail(cliente, newPass);
	}

	//Gerar 10 caracteres que podem ser dígitos ou letras.
	private String newPassword() {
		char[] vet = new char [10];
		for(int i = 0; i < 10; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}

	//Para gerar o digito foi utilizado o site Unicode.com
	//onde ele viu que de 0 a 9 tem código de 48 a 57
	private char randomChar() {
		int opt = rand.nextInt(3);
		if(opt == 0) { // gera um digito
			return (char) (rand.nextInt(10) + 48);
		}
		else if(opt == 1) {//gera letra maiuscula
			return (char) (rand.nextInt(26) + 65);
		}
		else { //gera letra minuscula 
			return (char) (rand.nextInt(26) + 97);
		}
	}
	
	
}
