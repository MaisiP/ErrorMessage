package mx.edu.utez.scv.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="expediente")
public class ExpedienteEntity implements Serializable{
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fecha;
	@ManyToOne
	private VeterinarioEntity veterinario;
	@ManyToOne
	private MascotaEntity mascota;
	
	
	public ExpedienteEntity() {
		mascota= new MascotaEntity();
		veterinario = new VeterinarioEntity();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public VeterinarioEntity getVeterinario() {
		return veterinario;
	}
	public void setVeterinario(VeterinarioEntity veterinario) {
		this.veterinario = veterinario;
	}
	public MascotaEntity getMascota() {
		return mascota;
	}
	public void setMascota(MascotaEntity mascota) {
		this.mascota = mascota;
	}
	
}
