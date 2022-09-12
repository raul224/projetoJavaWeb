package infnet.edu.seguros.model.repository;

import infnet.edu.seguros.model.domain.Seguro;
import infnet.edu.seguros.model.domain.SeguroDomicilio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeguroDomilicioRepository extends CrudRepository<SeguroDomicilio, Integer> {
    @Query("from Seguro s where s.usuario.id = :idUsuario")
    List<Seguro> ObterLista(Integer idUsuario);
}
