package infnet.edu.seguros.model.service;

import infnet.edu.seguros.model.domain.Cliente;
import infnet.edu.seguros.model.domain.Usuario;
import infnet.edu.seguros.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public void incluir(Cliente cliente) {
        repository.save(cliente);
    }

    public List<Cliente> getAll(){
        return (List<Cliente>) repository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
    }

    public List<Cliente> getAllByUsu(Usuario usu){
        return (List<Cliente>) repository.ObterLista(usu.getId(), Sort.by(Sort.Direction.ASC, "nome"));
    }

    public Cliente getById(Integer id){
        return repository.findById(id).orElse(null);
    }

    public void excluir(Integer id) {
        repository.deleteById(id);
    }
}
