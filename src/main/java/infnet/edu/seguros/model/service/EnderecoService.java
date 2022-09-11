package infnet.edu.seguros.model.service;

import infnet.edu.seguros.model.domain.Endereco;
import infnet.edu.seguros.model.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    public Endereco buscarCep(String cep){
        Endereco e = new Endereco();
        e.setBairro("bairro"+cep);
        e.setCep(cep);
        e.setComplemento("complemento"+cep);
        e.setLocalidade("localidade"+cep);
        e.setLogradouro("logradouro"+cep);
        e.setUf("uf"+cep);
        return e;
    }
}