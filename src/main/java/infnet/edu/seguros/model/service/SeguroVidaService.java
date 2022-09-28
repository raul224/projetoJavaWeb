package infnet.edu.seguros.model.service;

import infnet.edu.seguros.model.domain.SeguroVida;
import infnet.edu.seguros.model.domain.Usuario;
import infnet.edu.seguros.model.repository.SeguroVidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
        return repository.findAll(Sort.by(Sort.Direction.DESC, "anoNascimento"));
    }

    public SeguroVida obterPorId(Integer id){
        return repository.findById(id).orElse(null);
    }

    public List<SeguroVida> getAllByUsu(Usuario usu){
        return repository.ObterLista(usu.getId(), Sort.by(Sort.Direction.DESC, "anoNascimento"));
    }

    public void excluir(Integer id) {
        repository.deleteById(id);
    }
}
