package infnet.edu.seguros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import infnet.edu.seguros.model.domain.Usuario;
import infnet.edu.seguros.model.service.UsuarioService;

import java.util.List;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping(value = "/usuario")
	public String TelaCadastro() {
		return "usuario/cadastro";
	}

	@GetMapping(value = "/usuario/listar")
	public String TelaLista(Model model) {
		List<Usuario> listagem = service.listar();
		model.addAttribute("listagem", listagem);
		return "usuario/lista";
	}
	
	@PostMapping(value = "/usuario/incluir")
	public String IncluirSeguro(Usuario usuario) {
		service.incluir(usuario);
		return "redirect:/login";
	}

	@GetMapping(value = "/usuario/{id}/excluir")
	public String ExcluirUsuario(@PathVariable Integer id) {
		service.excluir(id);
		return "usuario/lista";
	}
}
