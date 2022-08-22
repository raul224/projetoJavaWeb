package infnet.edu.seguros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import infnet.edu.seguros.model.service.UsuarioService;

@Controller
public class AppController {
	
	@Autowired
	private UsuarioService usuService;
	private String mensagem;

	@GetMapping(value = "/")
	public String telaLogin(Model model) {
		
		model.addAttribute("msg", mensagem);

		return "login";
	}

	@GetMapping(value = "/home")
	public String telaHome() {
		return "index";
	}

	@PostMapping(value = "/login")
	public String validar(@RequestParam String email, @RequestParam String senha) {

		if(usuService.validar(email, senha)) {
			return "redirect:/home";
		}
		
		mensagem = "Credenciais incorretas para o e-mail "+email+"!!!";
		
		return "redirect:/";
	}
	
}
