package infnet.edu.seguros.loader;

import infnet.edu.seguros.model.domain.SeguroVeiculo;
import infnet.edu.seguros.model.domain.SeguroVida;
import infnet.edu.seguros.model.domain.Usuario;
import infnet.edu.seguros.model.service.ClienteService;
import infnet.edu.seguros.model.service.SeguroVeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Order(4)
@Component
public class SeguroVeiculoLoader implements ApplicationRunner {
    @Autowired
    private SeguroVeiculoService service;

    @Override
    public void run(ApplicationArguments args) throws Exception{
        Usuario admin = new Usuario();
        admin.setId(1);

        Usuario user = new Usuario();
        user.setId(2);

        SeguroVeiculo seguro = new SeguroVeiculo();
        seguro.setNumeroContrato(4);
        seguro.setCrlv("185936");
        seguro.setPlaca("KZW1985");
        seguro.setTipoVeiculo("Moto");
        seguro.setAtivo(true);
        seguro.setDataAssinatura(LocalDateTime.now());
        seguro.setDataFim(seguro.getDataAssinatura().plusMonths(12));
        seguro.setUsuario(admin);
        seguro.setValorContrato(200);
        seguro.setValorIndenizacao(4000);

        service.incluir(seguro);

        SeguroVeiculo seguroAdm = new SeguroVeiculo();
        seguro.setNumeroContrato(5);
        seguroAdm.setCrlv("727200");
        seguroAdm.setTipoVeiculo("Carro");
        seguroAdm.setPlaca("SLM2039");
        seguroAdm.setAtivo(true);
        seguroAdm.setDataAssinatura(LocalDateTime.now());
        seguroAdm.setDataFim(seguroAdm.getDataAssinatura().plusMonths(12));
        seguroAdm.setUsuario(user);
        seguroAdm.setValorContrato(600);
        seguroAdm.setValorIndenizacao(8000);

        service.incluir(seguroAdm);

        SeguroVeiculo seguroS = new SeguroVeiculo();
        seguroS.setNumeroContrato(6);
        seguroS.setCrlv("871193");
        seguroS.setTipoVeiculo("Moto");
        seguroS.setPlaca("KVW6076");
        seguroS.setAtivo(true);
        seguroS.setDataAssinatura(LocalDateTime.now());
        seguroS.setDataFim(seguroS.getDataAssinatura().plusMonths(12));
        seguroS.setUsuario(admin);
        seguroS.setValorContrato(300);
        seguroS.setValorIndenizacao(6000);

        service.incluir(seguroS);

        seguro = service.obterPorId(4);

        System.out.println("Inclusão do primeiro contrato: " + seguro.getNumeroContrato());

        System.out.println("### Seguros do usuário admin:");
        for(SeguroVeiculo b : service.getAllByUsu(admin)) {
            System.out.printf("%d - %s - %s\n",
                    b.getNumeroContrato(),
                    b.getUsuario(),
                    b.getPlaca()
            );
        }

        service.excluir(5);

        System.out.println("### Seguros do user:");
        for(SeguroVeiculo b : service.getAllByUsu(user)) {
            System.out.printf("%d - %s - %s\n",
                    b.getNumeroContrato(),
                    b.getUsuario(),
                    b.getPlaca()
            );
        }

        System.out.println("### Seguros do usuário admin:");
        for(SeguroVeiculo b : service.getAllByUsu(admin)) {
            System.out.printf("%d - %s - %s\n",
                    b.getNumeroContrato(),
                    b.getUsuario(),
                    b.getPlaca()
            );
        }

        try {
            seguro = service.obterPorId(5);
            System.out.println("Contrato nao excluido: " + seguro.getNumeroContrato());
        } catch (NullPointerException e) {
            System.err.println("[ERRO] " + e.getMessage());
        }
    }
}
