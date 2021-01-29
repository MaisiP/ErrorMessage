package mx.edu.utez.scv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.scv.entity.VeterinarioEntity;

@Repository
public interface VeterinarioRepository extends JpaRepository<VeterinarioEntity, Long> {

}
