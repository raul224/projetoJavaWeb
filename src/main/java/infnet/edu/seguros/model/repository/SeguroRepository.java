package infnet.edu.seguros.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import infnet.edu.seguros.model.domain.Seguro;

@Repository
public interface SeguroRepository extends CrudRepository<Seguro, Integer> {
	
}
