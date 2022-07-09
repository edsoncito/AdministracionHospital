package com.edsongonzalo.controller;

import com.edsongonzalo.util.encripto.encriptobasico;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class loginRest {
	
	encriptobasico encriptobasico  = new encriptobasico();

	@PostMapping("/login")
    public String login(String user, String pass) {
		//encriptobasico.desencriptar(pass);
		if(user =="edson" && pass == "pass"){

		}
		return user;
	}

	@PostMapping("/crear")
    public String Crear(String user, String pass) {

		encriptobasico.encriptarBasico(pass);

		if(user =="edson" && pass == "pass"){

		}

		return user;
	}

	
}
