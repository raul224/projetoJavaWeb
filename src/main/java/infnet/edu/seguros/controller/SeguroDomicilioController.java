package infnet.edu.seguros.controller;

import infnet.edu.seguros.model.domain.Endereco;
import infnet.edu.seguros.model.domain.SeguroDomicilio;
import infnet.edu.seguros.model.domain.Usuario;
import infnet.edu.seguros.model.service.EnderecoService;
import infnet.edu.seguros.model.service.SeguroDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SeguroDomicilioController {
    private String mensagem;
    @Autowired
    private SeguroDomicilioService service;
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping(value = "/seguro/domicilio")
    public String TelaCadastro() {
        return "domicilio/cadastro";
    }

    @GetMapping(value = "/seguro/domicilio/listar")
    public String ListarSeguros(Model model, @SessionAttribute("user") Usuario usu){
        mensagem = "Listagem realizada";
        if(usu.admin){
            model.addAttribute("listagem", service.obterLista());
        } else {
            model.addAttribute("listagem", service.GetAllByUsu(usu));
        }
        model.addAttribute("msg", mensagem);
        return "domicilio/lista";
    }

    @PostMapping(value = "/seguro/domicilio/incluir")
    public String IncluirSeguro(SeguroDomicilio seguro, @SessionAttribute("user") Usuario usu) {
        seguro.setUsuario(usu);
        service.incluir(seguro);
        return "redirect:/seguro/domicilio/listar";
    }

    @GetMapping(value = "seguro/domicilio/{id}/excluir")
    public String Excluir(@PathVariable Integer id) {
        service.Excluir(id);
        mensagem = "Excluído com sucesso";
        return "redirect:/seguro/domicilio/listar";
    }

    @PostMapping(value = "/cep")
    public String buscaCep(@RequestParam String cep, Model model){
        Endereco end = enderecoService.buscarCep(cep);
        model.addAttribute("endereco",end);
        return "domicilio/cadastro";
    }
}
