package infnet.edu.seguros.model.repository;

import infnet.edu.seguros.model.domain.Cliente;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import infnet.edu.seguros.model.domain.Usuario;

import java.util.List;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{

	@Query("from Usuario u where u.email = :email and u.senha = :senha")
	Usuario autenticacao(String email, String senha);

	List<Usuario> findAll(Sort sort);
}
