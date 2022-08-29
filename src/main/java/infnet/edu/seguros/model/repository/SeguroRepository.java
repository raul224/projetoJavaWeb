package infnet.edu.seguros.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import infnet.edu.seguros.model.domain.Seguro;

@Repository
public interface SeguroRepository extends CrudRepository<Seguro, Integer> {
	
	@Query("from Seguro s where s.usuario.id = :idUsuario")
	List<Seguro> ObterLista(Integer idUsuario);
}
