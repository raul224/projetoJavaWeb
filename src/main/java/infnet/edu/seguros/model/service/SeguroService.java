package infnet.edu.seguros.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
	
	public List<Seguro> getAllByUsu(Usuario usu){
		return seguroRepository.ObterLista(usu.getId(), Sort.by(Sort.Direction.DESC, "valorContrato"));
	}

	public Seguro getById(Integer id){
		return seguroRepository.findById(id).orElse(null);
	}
	
	public void excluir(Integer id) {
		seguroRepository.deleteById(id);
	}
	
}