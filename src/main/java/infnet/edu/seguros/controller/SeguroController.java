package infnet.edu.seguros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import infnet.edu.seguros.model.domain.Seguro;
import infnet.edu.seguros.model.domain.Usuario;
import infnet.edu.seguros.model.service.SeguroService;

@Controller
public class SeguroController {
	
	private String mensagem;
	
	@Autowired
	private SeguroService service;
	
	@GetMapping(value = "/seguro")
	public String TelaCadastro() {
		return "seguro/cadastro";
	}
	
	@GetMapping(value = "/seguro/listar")
	public String ListarSeguros(Model model, @SessionAttribute("user") Usuario usu){
		mensagem = "Listagem realizada";
		model.addAttribute("listagem", service.GetAll(usu));
		model.addAttribute("msg", mensagem);
		
		return "seguro/lista";
	}
	
	@PostMapping(value = "/seguro/incluir")
	public String IncluirSeguro(Seguro seguro, @SessionAttribute("user") Usuario usu) {
		seguro.setUsuario(usu);
		service.IncluirSeguro(seguro);
		
		return "redirect:/seguro/listar";
	}
	
	@GetMapping(value = "seguro/{id}/excluir")
	public String Excluir(@PathVariable Integer id) {
		service.Excluir(id);
		
		mensagem = "Excluído com sucesso";
		
		return "redirect:/seguro/listar";
	}
}
