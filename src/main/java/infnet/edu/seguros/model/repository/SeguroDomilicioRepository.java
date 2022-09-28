package infnet.edu.seguros.model.repository;

import infnet.edu.seguros.model.domain.Cliente;
import infnet.edu.seguros.model.domain.SeguroDomicilio;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeguroDomilicioRepository extends CrudRepository<SeguroDomicilio, Integer> {
    @Query("from SeguroDomicilio s where s.usuario.id = :idUsuario")
    List<SeguroDomicilio> ObterLista(Integer idUsuario, Sort sort);

    List<SeguroDomicilio> findAll(Sort sort);
}
