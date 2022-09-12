package infnet.edu.seguros.model.repository;

import infnet.edu.seguros.model.domain.SeguroVeiculo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeguroVeiculoRepository extends CrudRepository<SeguroVeiculo, Integer> {
}
