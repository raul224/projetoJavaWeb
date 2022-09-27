package infnet.edu.seguros.loader;

import infnet.edu.seguros.model.service.OrcamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(6)
@Component
public class OrcamentoLoader implements ApplicationRunner {
    @Autowired
    private OrcamentoService service;

    @Override
    public void run(ApplicationArguments args) throws Exception{

    }
}
