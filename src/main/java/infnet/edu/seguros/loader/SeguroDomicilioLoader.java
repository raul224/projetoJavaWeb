package infnet.edu.seguros.loader;

import infnet.edu.seguros.model.domain.Endereco;
import infnet.edu.seguros.model.domain.SeguroDomicilio;
import infnet.edu.seguros.model.domain.SeguroVeiculo;
import infnet.edu.seguros.model.domain.Usuario;
import infnet.edu.seguros.model.service.ClienteService;
import infnet.edu.seguros.model.service.SeguroDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Order(3)
@Component
public class SeguroDomicilioLoader implements ApplicationRunner {
    @Autowired
    private SeguroDomicilioService service;

    @Override
    public void run(ApplicationArguments args) throws Exception{
        Usuario admin = new Usuario();
        admin.setId(1);

        Usuario user = new Usuario();
        user.setId(2);

        Endereco endereco = new Endereco();
        endereco.setBairro("bairro");
        endereco.setCep("cep");
        endereco.setComplemento("complemento");
        endereco.setLocalidade("localidade");
        endereco.setLogradouro("logradouro");
        endereco.setUf("uf");

        SeguroDomicilio seguro = new SeguroDomicilio();
        seguro.setNumeroContrato(1);
        seguro.setCpfProprietario("18593655742");
        seguro.setMetragemImovel(2000);
        seguro.setEndereco(endereco);
        seguro.setAtivo(true);
        seguro.setDataAssinatura(LocalDateTime.now());
        seguro.setDataFim(seguro.getDataAssinatura().plusMonths(12));
        seguro.setUsuario(admin);
        seguro.setValorContrato(200);
        seguro.setValorIndenizacao(4000);

        service.incluir(seguro);

        Endereco enderecoAdm = new Endereco();
        endereco.setBairro("bairro adm");
        endereco.setCep("cep adm");
        endereco.setComplemento("complemento adm");
        endereco.setLocalidade("localidade adm");
        endereco.setLogradouro("logradouro adm");
        endereco.setUf("uf adm");

        SeguroDomicilio seguroAdm = new SeguroDomicilio();
        seguro.setNumeroContrato(2);
        seguroAdm.setCpfProprietario("72720090872");
        seguroAdm.setMetragemImovel(3000);
        seguroAdm.setEndereco(enderecoAdm);
        seguroAdm.setAtivo(true);
        seguroAdm.setDataAssinatura(LocalDateTime.now());
        seguroAdm.setDataFim(seguroAdm.getDataAssinatura().plusMonths(12));
        seguroAdm.setUsuario(user);
        seguroAdm.setValorContrato(600);
        seguroAdm.setValorIndenizacao(8000);

        service.incluir(seguroAdm);

        Endereco enderecoN = new Endereco();
        enderecoN.setBairro("bairro N");
        enderecoN.setCep("cep N");
        enderecoN.setComplemento("complemento N");
        enderecoN.setLocalidade("localidade N");
        enderecoN.setLogradouro("logradouro N");
        enderecoN.setUf("uf N");

        SeguroDomicilio seguroS = new SeguroDomicilio();
        seguroS.setNumeroContrato(3);
        seguroS.setCpfProprietario("87119390456");
        seguroS.setMetragemImovel(1000);
        seguroS.setEndereco(enderecoN);
        seguroS.setAtivo(true);
        seguroS.setDataAssinatura(LocalDateTime.now());
        seguroS.setDataFim(seguroS.getDataAssinatura().plusMonths(12));
        seguroS.setUsuario(admin);
        seguroS.setValorContrato(300);
        seguroS.setValorIndenizacao(6000);

        service.incluir(seguroS);

        seguro = service.obterPorId(1);

        System.out.println("Inclusão do primeiro contrato: " + seguro.getNumeroContrato());

        System.out.println("### Seguros do usuário admin:");
        for(SeguroDomicilio b : service.getAllByUsu(admin)) {
            System.out.printf("%d - %s - %s\n",
                    b.getNumeroContrato(),
                    b.getUsuario(),
                    b.getMetragemImovel()
            );
        }

        service.excluir(2);

        System.out.println("### Seguros do user:");
        for(SeguroDomicilio b : service.getAllByUsu(user)) {
            System.out.printf("%d - %s - %s\n",
                    b.getNumeroContrato(),
                    b.getUsuario(),
                    b.getMetragemImovel()
            );
        }

        System.out.println("### Seguros do usuário admin:");
        for(SeguroDomicilio b : service.getAllByUsu(admin)) {
            System.out.printf("%d - %s - %s\n",
                    b.getNumeroContrato(),
                    b.getUsuario(),
                    b.getMetragemImovel()
            );
        }

        try {
            seguro = service.obterPorId(2);
            System.out.println("Contrato nao excluido: " + seguro.getNumeroContrato());
        } catch (NullPointerException e) {
            System.err.println("[ERRO] " + e.getMessage());
        }
    }
}
