package Logico;

public class Administrativo extends Empleado {

	private String areaTrabajo;

	public Administrativo(int codigo, String nombre, double telefono, String direccion, double sueldo, String usuario,
			String clave, String areaTrabajo) {
		super(codigo, nombre, telefono, direccion, sueldo, usuario, clave);
		this.areaTrabajo = areaTrabajo;
	}

	public String getAreaTrabajo() {
		return areaTrabajo;
	}

	public void setAreaTrabajo(String areaTrabajo) {
		this.areaTrabajo = areaTrabajo;
	} 
	
	

}
