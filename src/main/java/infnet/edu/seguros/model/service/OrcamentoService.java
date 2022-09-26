package infnet.edu.seguros.model.service;

import infnet.edu.seguros.model.domain.Orcamento;
import infnet.edu.seguros.model.domain.Usuario;
import infnet.edu.seguros.model.repository.OrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrcamentoService {

    @Autowired
    private OrcamentoRepository repository;

    public void incluir(Orcamento orcamento){
        repository.save(orcamento);
    }

    public List<Orcamento> obterLista(){
        return (List<Orcamento>)repository.findAll();
    }

    public Orcamento obterPorId(Integer id){
        return repository.findById(id).orElse(null);
    }

    public List<Orcamento> getAllByUsu(Usuario usu){
        return (List<Orcamento>) repository.obterLista(usu.getId(), Sort.by(Sort.Direction.ASC, "dataEmissao"));
    }

    public void excluir(Integer id) {
        repository.deleteById(id);
    }
}
