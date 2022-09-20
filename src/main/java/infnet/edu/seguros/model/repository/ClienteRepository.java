package infnet.edu.seguros.model.repository;

import infnet.edu.seguros.model.domain.Cliente;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
    @Query("from Cliente s where s.usuario.id = :idUsuario")
    List<Cliente> ObterLista(Integer idUsuario, Sort sort);

    List<Cliente> findAll(Sort sort);
}
