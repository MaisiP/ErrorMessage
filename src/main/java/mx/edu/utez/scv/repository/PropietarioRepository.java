package mx.edu.utez.scv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.scv.entity.PropietarioEntity;

@Repository
public interface PropietarioRepository extends JpaRepository<PropietarioEntity, Long> {

}
