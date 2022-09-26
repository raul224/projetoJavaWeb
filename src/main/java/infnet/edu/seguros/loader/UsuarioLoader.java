package infnet.edu.seguros.loader;

import infnet.edu.seguros.model.domain.Usuario;
import infnet.edu.seguros.model.service.ClienteService;
import infnet.edu.seguros.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class UsuarioLoader implements ApplicationRunner {
    @Autowired
    private UsuarioService service;

    @Override
    public void run(ApplicationArguments args) throws Exception{
        Usuario admin = new Usuario();
        admin.setAdmin(true);
        admin.setEmail("raul.pires@infnet.com");
        admin.setNome("Raul Pires");
        admin.setSenha("123456");

        service.incluir(admin);

        Usuario usu = new Usuario();
        usu.setAdmin(false);
        usu.setEmail("rafael@gmail.com");
        usu.setNome("Rafael Araujo");
        usu.setSenha("123456");

        service.incluir(usu);

        System.out.println("Usuários cadastrados: ");
        for(Usuario u : service.listar()) {
            System.out.println(u.getNome());
        }
    }
}
