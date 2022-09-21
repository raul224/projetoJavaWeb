package infnet.edu.seguros.controller;

import infnet.edu.seguros.model.domain.Orcamento;
import infnet.edu.seguros.model.domain.Usuario;
import infnet.edu.seguros.model.service.OrcamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrcamentoController {
    private String mensagem;
    @Autowired
    private OrcamentoService service;

    @GetMapping(value = "/orcamento")
    public String TelaCadastro() {
        return "domicilio/cadastro";
    }

    @GetMapping(value = "/orcamento/listar")
    public String ListarOrcamentos(Model model, @SessionAttribute("user") Usuario usu){
        mensagem = "Listagem realizada";
        if(usu.admin){
            model.addAttribute("listagem", service.obterLista());
        } else {
            model.addAttribute("listagem", service.GetAllByUsu(usu));
        }
        model.addAttribute("msg", mensagem);
        return "orcamento/lista";
    }

    @PostMapping(value = "/orcamento/incluir")
    public String IncluirOrcamento(Orcamento orcamento, @SessionAttribute("user") Usuario usu) {
        orcamento.setUsuario(usu);
        service.incluir(orcamento);
        return "redirect:/orcamento/listar";
    }

    @GetMapping(value = "/orcamento/{id}/excluir")
    public String Excluir(@PathVariable Integer id) {
        service.Excluir(id);
        mensagem = "Orcamento "+ id + " excluido com sucesso";
        return "redirect:/orcamento/listar";
    }
}
