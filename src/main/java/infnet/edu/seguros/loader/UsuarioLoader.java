package infnet.edu.seguros.loader;

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

    }
}
