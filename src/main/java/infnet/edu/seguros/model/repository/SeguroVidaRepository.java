package infnet.edu.seguros.model.repository;

import infnet.edu.seguros.model.domain.SeguroVida;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeguroVidaRepository extends CrudRepository<SeguroVida, Integer> {
}
