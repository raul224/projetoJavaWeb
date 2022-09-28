package infnet.edu.seguros.controller;

import infnet.edu.seguros.model.domain.Endereco;
import infnet.edu.seguros.model.domain.SeguroDomicilio;
import infnet.edu.seguros.model.domain.Usuario;
import infnet.edu.seguros.model.service.EnderecoService;
import infnet.edu.seguros.model.service.SeguroDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class SeguroDomicilioController {
    private String mensagem;
    @Autowired
    private SeguroDomicilioService service;
    @Autowired
    private SeguroController seguroController;
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping(value = "/seguro/domicilio")
    public String TelaCadastro() {
        return "domicilio/cadastro";
    }

    @GetMapping(value = "/seguro/domicilio/listar")
    public String ListarSeguros(Model model, @SessionAttribute("user") Usuario usu){
        model.addAttribute("listagem", service.getAllByUsu(usu));
        model.addAttribute("msg", mensagem);
        return "domicilio/lista";
    }

    @PostMapping(value = "/seguro/domicilio/incluir")
    public String IncluirSeguro(
            SeguroDomicilio seguro,
            Endereco endereco,
            @SessionAttribute("user") Usuario usu,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime assinatura,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fim) {
        seguro.setUsuario(usu);
        seguro.setDataAssinatura(assinatura);
        seguro.setDataFim(fim);
        seguro.setEndereco(endereco);
        service.incluir(seguro);
        return "redirect:/seguro/domicilio/listar";
    }

    @GetMapping(value = "/seguro/domicilio/{id}/excluir")
    public String Excluir(@PathVariable Integer id) {
        try {
            seguroController.Exclusao(id);
            mensagem = "Seguro " + id + " foi excluido com sucesso";
        } catch (Exception e){
            mensagem = "Não é possível excluir esse seguro por estar associado a um orçamento";
        }
        return "redirect:/seguro/domicilio/listar";
    }

    @PostMapping(value = "/cep")
    public String buscaCep(@RequestParam String cep, Model model){
        Endereco end = enderecoService.buscarCep(cep);
        model.addAttribute("endereco",end);
        return "domicilio/cadastro";
    }
}
