package mx.edu.utez.scv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.utez.scv.entity.MascotaEntity;
import mx.edu.utez.scv.repository.MascotaRepository;

@Service
@Transactional
public class MascotaService {
	
	@Autowired
	private MascotaRepository mascotaRepository;
	public List<MascotaEntity> getAll(){
		return mascotaRepository.findAll();
	}
	
	public void save (MascotaEntity mascota) {
		mascotaRepository.save(mascota);
	}
	
	public MascotaEntity get (long id) {
		return mascotaRepository.findById(id).get();
	}
	
	public void delete(long id) {
		mascotaRepository.deleteById(id);
	}

}
