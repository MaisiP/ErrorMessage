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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="veterinario")
public class VeterinarioEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private String correo;
	private String cedulaProfesional;
	private String especialidad;
	@Column(name="vigente")
	private boolean status;
	
	@OneToMany(mappedBy = "veterinario",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<ExpedienteEntity> expedientes;
	
	public VeterinarioEntity() {
		expedientes= new ArrayList<ExpedienteEntity>();
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
	public String getCedulaProfesional() {
		return cedulaProfesional;
	}
	public void setCedulaProfesional(String cedulaProfesional) {
		this.cedulaProfesional = cedulaProfesional;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public List<ExpedienteEntity> getExpedientes() {
		return expedientes;
	}
	public void setExpedientes(List<ExpedienteEntity> expedientes) {
		this.expedientes = expedientes;
	}
	public void addExpediente(ExpedienteEntity expediente) {
		expedientes.add(expediente);
	}
	public String toString() {
		return nombre + " "+primerApellido+" "+segundoApellido;
	}
}
