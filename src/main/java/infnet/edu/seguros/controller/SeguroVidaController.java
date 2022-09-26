package infnet.edu.seguros.controller;

import infnet.edu.seguros.model.domain.SeguroVida;
import infnet.edu.seguros.model.domain.Usuario;
import infnet.edu.seguros.model.service.SeguroVidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class SeguroVidaController {
    private String mensagem;
    @Autowired
    private SeguroVidaService service;
    @Autowired
    private SeguroController seguroController;

    @GetMapping(value = "/seguro/vida")
    public String TelaCadastro() {
        return "vida/cadastro";
    }

    @GetMapping(value = "/seguro/vida/listar")
    public String ListarSeguros(Model model, @SessionAttribute("user") Usuario usu){
        mensagem = "Listagem realizada";
        if(usu.admin){
            model.addAttribute("listagem", service.obterLista());
        } else {
            model.addAttribute("listagem", service.getAllByUsu(usu));
        }
        model.addAttribute("msg", mensagem);
        return "vida/lista";
    }

    @PostMapping(value = "/seguro/vida/incluir")
    public String IncluirSeguro(SeguroVida seguro, @SessionAttribute("user") Usuario usu) {
        seguro.setUsuario(usu);
        service.incluir(seguro);
        return "redirect:/seguro/vida/listar";
    }

    @GetMapping(value = "/seguro/vida/{id}/excluir")
    public String Excluir(@PathVariable Integer id) {
        try {
            seguroController.Exclusao(id);
            mensagem = "Seguro " + id + " foi excluido com sucesso";
        } catch (Exception e){
            mensagem = "Não é possível excluir esse seguro por estar associado a um orçamento";
        }
        return "redirect:/seguro/vida/listar";
    }

}
