package infnet.edu.seguros.loader;

import infnet.edu.seguros.model.service.ClienteService;
import infnet.edu.seguros.model.service.SeguroDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SeguroDomicilioLoader implements ApplicationRunner {
    @Autowired
    private SeguroDomicilioService service;

    @Override
    public void run(ApplicationArguments args) throws Exception{
        
    }
}
