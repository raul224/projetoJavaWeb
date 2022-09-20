package infnet.edu.seguros.model.service;

import infnet.edu.seguros.model.domain.SeguroDomicilio;
import infnet.edu.seguros.model.domain.Usuario;
import infnet.edu.seguros.model.repository.SeguroDomilicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeguroDomicilioService {

    @Autowired
    private SeguroDomilicioRepository repository;

    public void incluir(SeguroDomicilio seguro){
        repository.save(seguro);
    }

    public List<SeguroDomicilio> obterLista(){
        return (List<SeguroDomicilio>)repository.findAll();
    }

    public SeguroDomicilio obterPorId(Integer id){
        return repository.findById(id).orElse(null);
    }

    public List<SeguroDomicilio> GetAllByUsu(Usuario usu){
        return (List<SeguroDomicilio>) repository.ObterLista(usu.getId(), Sort.by(Sort.Direction.ASC, "metragemImovel"));
    }

    public void Excluir(Integer id) {
        repository.deleteById(id);
    }
}
