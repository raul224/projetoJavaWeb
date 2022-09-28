package infnet.edu.seguros.model.repository;

import infnet.edu.seguros.model.domain.Cliente;
import infnet.edu.seguros.model.domain.SeguroVeiculo;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeguroVeiculoRepository extends CrudRepository<SeguroVeiculo, Integer> {

    @Query("from SeguroVeiculo s where s.usuario.id = :idUsuario")
    List<SeguroVeiculo> ObterLista(Integer idUsuario, Sort sort);

    List<SeguroVeiculo> findAll(Sort sort);
}
