package mx.edu.utez.scv.model;

public class Mascota {
	
	private int id;
	private String nombre;
	private String categoria;
	private int edad;
	private boolean status;
	
	
	
	public Mascota() {
		
	}
	public Mascota(int id, String nombre, String categoria, int edad, boolean status) {
		
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.edad = edad;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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

}
