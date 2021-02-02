package mx.edu.utez.scv.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "mascota")
public class MascotaEntity implements Serializable {

	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String nombre;
	private String categoria;
	@NotNull
	private int edad;
	@Column(name="vigente")
	private boolean status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private PropietarioEntity propietarioEntity;
	
	@OneToMany(mappedBy = "mascota", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ExpedienteEntity> expedientes;
	
	public MascotaEntity() {
		expedientes = new ArrayList<ExpedienteEntity>();
	}
	
	public MascotaEntity(Long id, String nombre, String categoria, int edad, boolean status) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.edad = edad;
		this.status = status;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	public PropietarioEntity getPropietarioEntity() {
		return propietarioEntity;
	}
	
	public void addExpediente(ExpedienteEntity expediente) {
		expedientes.add(expediente);
	}

	public void setPropietarioEntity(PropietarioEntity propietarioEntity) {
		this.propietarioEntity = propietarioEntity;
	}

	@Override
	public String toString() {
		return "MascotaEntity [id=" + id + ", nombre=" + nombre + ", categoria=" + categoria + ", edad=" + edad
				+ ", status=" + status + ", propietarioEntity=" + propietarioEntity + ", expedientes=" + expedientes
				+ "]";
	}
	
		
}
