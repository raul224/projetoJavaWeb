package infnet.edu.seguros.model.repository;

import infnet.edu.seguros.model.domain.SeguroVida;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeguroVidaRepository extends CrudRepository<SeguroVida, Integer> {
    @Query("from SeguroVida s where s.usuario.id = :idUsuario")
    List<SeguroVida> ObterLista(Integer idUsuario, Sort sort);
}
