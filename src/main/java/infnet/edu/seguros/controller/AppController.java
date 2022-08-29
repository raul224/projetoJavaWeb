package infnet.edu.seguros.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import infnet.edu.seguros.model.domain.Usuario;
import infnet.edu.seguros.model.service.UsuarioService;

@SessionAttributes("user")
@Controller
public class AppController {
	
	@Autowired
	private UsuarioService usuService;
	private String mensagem;

	@GetMapping(value = "/login")
	public String telaLogin(Model model) {
		model.addAttribute("msg", mensagem);
		return "login";
	}

	@GetMapping(value = "/")
	public String telaHome() {
		return "index";
	}

	@PostMapping(value = "/login")
	public String validar(@RequestParam String email, @RequestParam String senha, Model model) {
		Usuario usu = usuService.validar(email, senha);
		if(usu != null) {
			model.addAttribute("user", usu);
			return "redirect:/";
		}
		mensagem = "Credenciais incorretas para o e-mail "+email+"!!!";
		return "redirect:/login";
	}
	
	@GetMapping(value = "/logout")
	public String Logout(HttpSession session, SessionStatus status) {
		status.setComplete();
		session.removeAttribute("user");
		return "redirect:/";
	}
}
