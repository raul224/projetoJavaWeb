package infnet.edu.seguros.model.service;

import infnet.edu.seguros.model.domain.Cliente;
import infnet.edu.seguros.model.domain.Usuario;
import infnet.edu.seguros.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public void IncluirSeguro(Cliente cliente) {
        repository.save(cliente);
    }

    public List<Cliente> GetAll(){
        return (List<Cliente>) repository.findAll();
    }

    public List<Cliente> GetAllByUsu(Usuario usu){
        return (List<Cliente>) repository.ObterLista(usu.getId());
    }

    public void Excluir(Integer id) {
        repository.deleteById(id);
    }
}
