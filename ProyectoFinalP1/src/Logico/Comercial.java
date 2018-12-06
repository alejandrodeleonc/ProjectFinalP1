package Logico;

public class Comercial extends Empleado {
	
	private String puesto;
	public Comercial(int codigo, String nombre, double telefono, String direccion, double sueldo, String usuario,
			String clave, String puesto) {
		super(codigo, nombre, telefono, direccion, sueldo, usuario, clave);
		this.puesto = puesto;
	}
		
}
