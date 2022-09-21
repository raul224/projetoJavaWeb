package infnet.edu.seguros.model.repository;

import infnet.edu.seguros.model.domain.Orcamento;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrcamentoRepository extends CrudRepository<Orcamento, Integer> {

    @Query("from Orcamento o where o.usuario.id = :idUsuario")
    List<Orcamento> obterLista(Integer idUsuario, Sort sort);
}
