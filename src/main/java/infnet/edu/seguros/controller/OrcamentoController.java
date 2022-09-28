package infnet.edu.seguros.controller;

import infnet.edu.seguros.model.domain.Orcamento;
import infnet.edu.seguros.model.domain.Usuario;
import infnet.edu.seguros.model.service.ClienteService;
import infnet.edu.seguros.model.service.OrcamentoService;
import infnet.edu.seguros.model.service.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class OrcamentoController {
    private String mensagem;
    @Autowired
    private OrcamentoService service;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private SeguroService seguroService;

    @GetMapping(value = "/orcamento")
    public String TelaCadastro(Model model, @SessionAttribute("user") Usuario usu) {
        model.addAttribute("clientes", clienteService.getAllByUsu(usu));
        model.addAttribute("seguros", seguroService.getAllByUsu(usu));
        return "orcamento/cadastro";
    }

    @GetMapping(value = "/orcamento/listar")
    public String ListarOrcamentos(Model model, @SessionAttribute("user") Usuario usu){
        model.addAttribute("listagem", service.getAllByUsu(usu));
        model.addAttribute("msg", mensagem);
        return "orcamento/lista";
    }

    @PostMapping(value = "/orcamento/incluir")
    public String IncluirOrcamento(Orcamento orcamento, @SessionAttribute("user") Usuario usu) {
        orcamento.setUsuario(usu);
        orcamento.setDataEmissao(LocalDateTime.now());
        service.incluir(orcamento);
        return "redirect:/orcamento/listar";
    }

    @GetMapping(value = "/orcamento/{id}/excluir")
    public String Excluir(@PathVariable Integer id) {
        service.excluir(id);
        mensagem = "Orcamento "+ id + " excluido com sucesso";
        return "redirect:/orcamento/listar";
    }
}
