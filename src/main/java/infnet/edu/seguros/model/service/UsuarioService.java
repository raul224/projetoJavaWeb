package infnet.edu.seguros.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import infnet.edu.seguros.model.domain.Usuario;
import infnet.edu.seguros.model.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuRepository;
	
	public void incluir(Usuario usuario) {
		usuRepository.save(usuario);
	}
	
	public Usuario validar(String email, String senha) {
		return usuRepository.autenticacao(email, senha);
	}

	public void excluir(Integer id){
		usuRepository.deleteById(id);
	}

	public Usuario getById(Integer id){
		return usuRepository.findById(id).orElse(null);
	}

	public List<Usuario> listar(){
		return (List<Usuario>) usuRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
	}
}
