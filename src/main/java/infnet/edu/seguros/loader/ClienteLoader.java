package infnet.edu.seguros.loader;

import infnet.edu.seguros.model.domain.Cliente;
import infnet.edu.seguros.model.domain.Usuario;
import infnet.edu.seguros.model.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ClienteLoader implements ApplicationRunner {
    @Autowired
    private ClienteService service;

    @Override
    public void run(ApplicationArguments args) throws Exception{
        Usuario usuario = new Usuario();
        usuario.setId(1);

        Cliente cliente = new Cliente();
        cliente.setTelefone("21988867650");
        cliente.setEmail("ana@ana.com");
        cliente.setNome("Ana Maria");
        cliente.setUsuario(usuario);

        service.incluir(cliente);
    }
}
