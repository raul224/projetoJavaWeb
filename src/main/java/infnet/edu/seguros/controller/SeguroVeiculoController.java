package infnet.edu.seguros.controller;

import infnet.edu.seguros.model.domain.SeguroVeiculo;
import infnet.edu.seguros.model.domain.Usuario;
import infnet.edu.seguros.model.service.EnderecoService;
import infnet.edu.seguros.model.service.SeguroVeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class SeguroVeiculoController {
    private String mensagem;
    @Autowired
    private SeguroVeiculoService service;
    @Autowired
    private SeguroController seguroController;

    @GetMapping(value = "/seguro/veiculo")
    public String TelaCadastro() {
        return "veiculo/cadastro";
    }

    @GetMapping(value = "/seguro/veiculo/listar")
    public String ListarSeguros(Model model, @SessionAttribute("user") Usuario usu){
        mensagem = "Listagem realizada";
        if(usu.admin){
            model.addAttribute("listagem", service.obterLista());
        } else {
            model.addAttribute("listagem", service.GetAllByUsu(usu));
        }
        model.addAttribute("msg", mensagem);
        return "veiculo/lista";
    }

    @PostMapping(value = "/seguro/veiculo/incluir")
    public String IncluirSeguro(SeguroVeiculo seguro, @SessionAttribute("user") Usuario usu) {
        seguro.setUsuario(usu);
        service.incluir(seguro);
        return "redirect:/seguro/veiculo/listar";
    }

    @GetMapping(value = "/seguro/veiculo/{id}/excluir")
    public String Excluir(@PathVariable Integer id) {
        try {
            seguroController.Exclusao(id);
            mensagem = "Seguro " + id + " foi excluido com sucesso";
        } catch (Exception e){
            mensagem = "Não é possível excluir esse seguro por estar associado a um orçamento";
        }
        return "redirect:/seguro/veiculo/listar";
    }
}
