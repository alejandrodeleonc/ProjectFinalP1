package Logico;

public class Administrativo extends Empleado {

	private String areaTrabajo;
	
	public Administrativo(String nombre, String apellido, String direccion, String cedula, String cargo,
			String fechadeNacimiento, String fechadeIngreso, String areaTrabajo) {
		super(nombre, apellido, direccion, cedula, cargo, fechadeNacimiento, fechadeIngreso);
		this.areaTrabajo = areaTrabajo;
	}
	
	public String getAreaTrabajo() {
		return areaTrabajo;
	}
	public void setAreaTrabajo(String areaTrabajo) {
		this.areaTrabajo = areaTrabajo;
	} 

}
