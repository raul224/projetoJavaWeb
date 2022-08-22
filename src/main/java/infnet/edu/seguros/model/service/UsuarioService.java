package infnet.edu.seguros.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import infnet.edu.seguros.model.domain.Usuario;
import infnet.edu.seguros.model.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuRepository;
	
	public boolean validar(String email, String senha) {
		Usuario usu = usuRepository.autenticacao(email, senha);
		return usu == null ? false : true;
	}
}
