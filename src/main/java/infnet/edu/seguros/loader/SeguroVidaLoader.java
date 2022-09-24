package infnet.edu.seguros.loader;

import infnet.edu.seguros.model.service.ClienteService;
import infnet.edu.seguros.model.service.SeguroVidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SeguroVidaLoader implements ApplicationRunner {
    @Autowired
    private SeguroVidaService service;

    @Override
    public void run(ApplicationArguments args) throws Exception{

    }
}
