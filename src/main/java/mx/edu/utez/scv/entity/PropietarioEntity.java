package mx.edu.utez.scv.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name ="propietario")
public class PropietarioEntity {
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String nombre;
	@NotEmpty
	private String primerApellido;
	@NotEmpty
	private String segundoApellido;
	private String correo;
	private String telefono;
	private String direccion;
	@Column(name="vigente")
	private boolean status;
	
	@OneToMany(mappedBy = "propietarioEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<MascotaEntity> mascotas;

	public PropietarioEntity() {
		mascotas = new ArrayList<MascotaEntity>();
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

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<MascotaEntity> getMascotas() {
		return mascotas;
	}

	public void setMascotas(List<MascotaEntity> mascotas) {
		this.mascotas = mascotas;
	}
	
	public void addMascota(MascotaEntity mascota) {
		mascotas.add(mascota);
	}
	

	public String toString() {
		return nombre + " "+primerApellido+" "+segundoApellido;
	}
	
	
}
