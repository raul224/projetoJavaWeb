package infnet.edu.seguros.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import infnet.edu.seguros.model.domain.Seguro;
import infnet.edu.seguros.model.repository.SeguroRepository;

@Service
public class SeguroService{
	
	@Autowired
	private SeguroRepository seguroRepository;
	
	public void IncluirSeguro(Seguro seguro) {
		seguroRepository.save(seguro);
	}
	
	public List<Seguro> GetAll(){
		return (List<Seguro>) seguroRepository.findAll();
	}
	
	public void Excluir(Integer id) {
		seguroRepository.deleteById(id);
	}
	
}