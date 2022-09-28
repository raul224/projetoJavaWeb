package infnet.edu.seguros.model.service;

import infnet.edu.seguros.clients.IEnderecoClient;
import infnet.edu.seguros.model.domain.Endereco;
import infnet.edu.seguros.model.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    @Autowired
    private IEnderecoClient enderecoClient;

    public Endereco buscarCep(String cep){
        return enderecoClient.buscaCep(cep);
    }

    public void incluir(Endereco endereco){
        repository.save(endereco);
    }
}