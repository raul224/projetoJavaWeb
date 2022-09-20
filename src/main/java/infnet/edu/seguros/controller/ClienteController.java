package infnet.edu.seguros.controller;

import infnet.edu.seguros.model.domain.Cliente;
import infnet.edu.seguros.model.domain.Usuario;
import infnet.edu.seguros.model.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ClienteController {
    private String mensagem;
    @Autowired
    private ClienteService service;

    @GetMapping(value = "/cliente")
    public String TelaCadastro() {
        return "seguro/cadastro";
    }

    @GetMapping(value = "/cliente/listar")
    public String ListarSeguros(Model model,  @SessionAttribute("user") Usuario usu){
        mensagem = "Listagem realizada";
        if(usu.admin){
            model.addAttribute("listagem", service.GetAll());
        } else {
            model.addAttribute("listagem", service.GetAllByUsu(usu));
        }
        model.addAttribute("msg", mensagem);
        return "cliente/lista";
    }

    @PostMapping(value = "/cliente/incluir")
    public String IncluirSeguro(Cliente cliente, @SessionAttribute("user") Usuario usu) {
        cliente.setUsuario(usu);
        service.IncluirSeguro(cliente);
        return "redirect:/seguro/listar";
    }

    @GetMapping(value = "cliente/{id}/excluir")
    public String Excluir(@PathVariable Integer id) {
        service.Excluir(id);
        mensagem = "Excluído com sucesso";
        return "redirect:/seguro/listar";
    }
}
