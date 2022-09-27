package infnet.edu.seguros.loader;

import infnet.edu.seguros.model.domain.SeguroVida;
import infnet.edu.seguros.model.domain.Usuario;
import infnet.edu.seguros.model.service.ClienteService;
import infnet.edu.seguros.model.service.SeguroVidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Order(5)
@Component
public class SeguroVidaLoader implements ApplicationRunner {
    @Autowired
    private SeguroVidaService service;

    @Override
    public void run(ApplicationArguments args) throws Exception{
        Usuario admin = new Usuario();
        admin.setId(1);

        Usuario user = new Usuario();
        user.setId(2);

        SeguroVida seguro = new SeguroVida();
        seguro.setNumeroContrato(7);
        seguro.setCpf("18593655742");
        seguro.setAnoNascimento(1999);
        seguro.setCpfBeneficiario("18222720767");
        seguro.setAtivo(true);
        seguro.setDataAssinatura(LocalDateTime.now());
        seguro.setDataFim(seguro.getDataAssinatura().plusMonths(12));
        seguro.setUsuario(admin);
        seguro.setValorContrato(200);
        seguro.setValorIndenizacao(4000);

        service.incluir(seguro);

        SeguroVida seguroAdm = new SeguroVida();
        seguro.setNumeroContrato(8);
        seguroAdm.setCpf("72720014028");
        seguroAdm.setAnoNascimento(1986);
        seguroAdm.setCpfBeneficiario("54437252039");
        seguroAdm.setAtivo(true);
        seguroAdm.setDataAssinatura(LocalDateTime.now());
        seguroAdm.setDataFim(seguroAdm.getDataAssinatura().plusMonths(12));
        seguroAdm.setUsuario(user);
        seguroAdm.setValorContrato(600);
        seguroAdm.setValorIndenizacao(8000);

        service.incluir(seguroAdm);

        SeguroVida seguroS = new SeguroVida();
        seguroS.setNumeroContrato(9);
        seguroS.setCpf("87119335006");
        seguroS.setAnoNascimento(1997);
        seguroS.setCpfBeneficiario("76219566076");
        seguroS.setAtivo(true);
        seguroS.setDataAssinatura(LocalDateTime.now());
        seguroS.setDataFim(seguroS.getDataAssinatura().plusMonths(12));
        seguroS.setUsuario(admin);
        seguroS.setValorContrato(300);
        seguroS.setValorIndenizacao(6000);

        service.incluir(seguroS);

        seguro = service.obterPorId(7);

        System.out.println("Inclusão do primeiro contrato: " + seguro.getNumeroContrato());

        System.out.println("### Seguros do usuário admin:");
        for(SeguroVida b : service.getAllByUsu(admin)) {
            System.out.printf("%d - %s - %s\n",
                    b.getNumeroContrato(),
                    b.getUsuario(),
                    b.getCpf()
            );
        }

        service.excluir(8);

        System.out.println("### Seguros do user:");
        for(SeguroVida b : service.getAllByUsu(user)) {
            System.out.printf("%d - %s - %s\n",
                    b.getNumeroContrato(),
                    b.getUsuario(),
                    b.getCpf()
            );
        }

        System.out.println("### Seguros do usuário admin:");
        for(SeguroVida b : service.getAllByUsu(admin)) {
            System.out.printf("%d - %s - %s\n",
                    b.getNumeroContrato(),
                    b.getUsuario(),
                    b.getCpf()
            );
        }

        try {
            seguro = service.obterPorId(8);
            System.out.println("Contrato nao excluido: " + seguro.getNumeroContrato());
        } catch (NullPointerException e) {
            System.err.println("[ERRO] " + e.getMessage());
        }
    }
}
