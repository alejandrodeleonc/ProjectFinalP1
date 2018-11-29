package Logico;

public class Comercial extends Empleado {
	
	private boolean servicio;
	private boolean mercadeo;
	public Comercial(int codigo, String nombre, double telefono, String direccion, double sueldo, String usuario,
			String clave, boolean servicio, boolean mercadeo) {
		super(codigo, nombre, telefono, direccion, sueldo, usuario, clave);
		this.servicio = servicio;
		this.mercadeo = mercadeo;
	}
	public boolean isServicio() {
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
