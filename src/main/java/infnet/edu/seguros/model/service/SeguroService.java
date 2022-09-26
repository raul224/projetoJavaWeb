package infnet.edu.seguros.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import infnet.edu.seguros.model.domain.Seguro;
import infnet.edu.seguros.model.domain.Usuario;
import infnet.edu.seguros.model.repository.SeguroRepository;

@Service
public class SeguroService{
	
	@Autowired
	private SeguroRepository seguroRepository;
	
	public void incluir(Seguro seguro) {
		seguroRepository.save(seguro);
	}
	
	public List<Seguro> getAll(){
		return (List<Seguro>) seguroRepository.findAll();
	}
	
	public List<Seguro> getAllByUsu(Usuario usu){
		return (List<Seguro>) seguroRepository.ObterLista(usu.getId());
	}

	public Seguro getById(Integer id){
		return seguroRepository.findById(id).orElse(null);
	}
	
	public void excluir(Integer id) {
		seguroRepository.deleteById(id);
	}
	
}