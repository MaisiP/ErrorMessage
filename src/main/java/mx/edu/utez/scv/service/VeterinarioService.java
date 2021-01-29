package mx.edu.utez.scv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.utez.scv.entity.VeterinarioEntity;
import mx.edu.utez.scv.repository.VeterinarioRepository;

@Service
@Transactional
public class VeterinarioService {
	
	@Autowired
	private VeterinarioRepository repository;
	
	public List<VeterinarioEntity> getAll(){
		return repository.findAll();
	}
	
	public void save(VeterinarioEntity veterinario) {
		repository.save(veterinario);
	}
	
	public VeterinarioEntity get(Long id) {
		return repository.getOne(id);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
