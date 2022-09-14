package infnet.edu.seguros.model.service;

import infnet.edu.seguros.model.domain.SeguroVida;
import infnet.edu.seguros.model.domain.Usuario;
import infnet.edu.seguros.model.repository.SeguroVidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeguroVidaService {
    @Autowired
    private SeguroVidaRepository repository;

    public void incluir(SeguroVida seguro){
        repository.save(seguro);
    }

    public List<SeguroVida> obterLista(){
        return (List<SeguroVida>)repository.findAll();
    }

    public SeguroVida obterPorId(Integer id){
        return repository.findById(id).orElse(null);
    }

    public List<SeguroVida> GetAllByUsu(Usuario usu){
        return (List<SeguroVida>) repository.ObterLista(usu.getId());
    }

    public void Excluir(Integer id) {
        repository.deleteById(id);
    }
}
