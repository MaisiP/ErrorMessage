package mx.edu.utez.scv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.scv.entity.ExpedienteEntity;
import mx.edu.utez.scv.repository.ExpedienteRepository;

@Service
public class ExpedienteService{
	
	@Autowired
	private ExpedienteRepository repository;
	
	public List<ExpedienteEntity> getAll(){
		return repository.findAll();
	}
	
	public void add (ExpedienteEntity expediente) {
		repository.save(expediente);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public ExpedienteEntity get (Long id) {
		return repository.getOne(id);
	}

}
