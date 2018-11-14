package Logico;

public class Comercial extends Empleado {
	
	private boolean servicio;
	private boolean mercadeo;
	
	public Comercial(String nombre, String apellido, String direccion, String cedula, String cargo,
			String fechadeNacimiento, String fechadeIngreso, boolean servicio, boolean mercadeo) {
		super(nombre, apellido, direccion, cedula, cargo, fechadeNacimiento, fechadeIngreso);
		this.servicio = servicio;
		this.mercadeo = mercadeo;
	}
	
	boolean isServicio() {
		return servicio;
	}
	public void setServicio(boolean servicio) {
		this.servicio = servicio;
	}
	public boolean isMercadeo() {
		return mercadeo;
	}
	public void setMercadeo(boolean mercadeo) {
		this.mercadeo = mercadeo;
	}
}
