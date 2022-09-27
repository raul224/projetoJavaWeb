package infnet.edu.seguros.loader;

import infnet.edu.seguros.model.domain.Cliente;
import infnet.edu.seguros.model.domain.Orcamento;
import infnet.edu.seguros.model.domain.Seguro;
import infnet.edu.seguros.model.domain.Usuario;
import infnet.edu.seguros.model.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Order(6)
@Component
public class OrcamentoLoader implements ApplicationRunner {
    @Autowired
    private OrcamentoService service;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private SeguroService seguroService;

    @Override
    public void run(ApplicationArguments args) throws Exception{
        Usuario usuario = usuarioService.getById(1);
        Cliente cliente = clienteService.getById(1);
        Seguro domicilio = seguroService.getById(1);
        Seguro veiculo = seguroService.getById(4);
        Seguro vida = seguroService.getById(7);

        Seguro[] lista = {domicilio, veiculo, vida};

        Orcamento orcamento = new Orcamento();
        orcamento.setDataEmissao(LocalDateTime.now());
        orcamento.setUsuario(usuario);
        orcamento.setCliente(cliente);
        orcamento.setSeguros(List.of(lista));

        service.incluir(orcamento);

        domicilio = seguroService.getById(3);
        veiculo = seguroService.getById(6);
        vida = seguroService.getById(9);

        Seguro[] lista2 = {domicilio, veiculo, vida};

        Orcamento orcamento2 = new Orcamento();
        orcamento2.setDataEmissao(LocalDateTime.now());
        orcamento2.setUsuario(usuario);
        orcamento2.setCliente(cliente);
        orcamento2.setSeguros(List.of(lista2));

        service.incluir(orcamento2);

        System.out.println(orcamento2.getUsuario().nome + ", orçamento 2 criado");

        service.excluir(2);

        try {
            orcamento = service.obterPorId(2);
            System.out.println("Contrato nao excluido: " + orcamento.getCliente().getNome());
        } catch (NullPointerException e) {
            System.err.println("[ERRO] " + e.getMessage());
        }
    }
}
