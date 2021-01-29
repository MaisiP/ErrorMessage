package mx.edu.utez.scv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.utez.scv.entity.PropietarioEntity;
import mx.edu.utez.scv.repository.PropietarioRepository;

@Service
@Transactional
public class PropietarioService {
	
	@Autowired
	private PropietarioRepository repository;
	
	public List<PropietarioEntity> getAll() {
		return repository.findAll();
	}
	
	public void save (PropietarioEntity propietario) {
		repository.save(propietario);
	}
	
	public PropietarioEntity get (Long id) {
		return repository.getOne(id);
	}
	
	public void delete (Long id) {
		repository.deleteById(id);
	}

}
