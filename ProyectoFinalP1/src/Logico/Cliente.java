package Logico;

import java.util.ArrayList;

public abstract class Cliente {
	
	protected String nombre;
	protected String apellido;
	protected String direccion;
	protected String telefono;
	protected String fechadeNacimiento;
	protected String fechadeIngreso;
	protected ArrayList<Plan> misPlanes;
	
	public Cliente(String nombre, String apellido, String direccion, String telefono, String fechadeNacimiento,
			String fechadeIngreso, ArrayList<Plan> misPlanes) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.telefono = telefono;
		this.fechadeNacimiento = fechadeNacimiento;
		this.fechadeIngreso = fechadeIngreso;
		this.misPlanes = misPlanes;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getFechadeNacimiento() {
		return fechadeNacimiento;
	}
	public void setFechadeNacimiento(String fechadeNacimiento) {
		this.fechadeNacimiento = fechadeNacimiento;
	}
	public String getFechadeIngreso() {
		return fechadeIngreso;
	}
	public void setFechadeIngreso(String fechadeIngreso) {
		this.fechadeIngreso = fechadeIngreso;
	}
	public ArrayList<Plan> getMisPlanes() {
		return misPlanes;
	}
	public void setMisPlanes(ArrayList<Plan> misPlanes) {
		this.misPlanes = misPlanes;
	}
	
}
