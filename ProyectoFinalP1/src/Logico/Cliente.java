package Logico;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Cliente implements Serializable {
	
	protected int codigo;
	protected String nombre;
	protected double telefono;
	protected String direccion;
	protected ArrayList<Plan> misPlanes;
	protected ArrayList<Factura> misFacturas;
	protected boolean estado;
	public Cliente(int codigo, String nombre, double telefono, String direccion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.misPlanes = new ArrayList<>();
		this.misFacturas = new ArrayList<>();
		this.estado = true;
	}
	public int getCodigo() {
		return codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getTelefono() {
		return telefono;
	}
	public void setTelefono(double telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public ArrayList<Plan> getMisPlanes() {
		return misPlanes;
	}
	public void addPlan(Plan plan) {
		this.misPlanes.add(plan);
	}
	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}
	public void addFactura(Factura factura) {
		this.misFacturas.add(factura);
	}
	public boolean getEstado() {
		return estado;
	}
	
	//metodo para validar el estado de un cliente, activo o desactivado.
	public void setEstado() {
		if(this.estado) {
			this.estado = false;
		}else{
			this.estado = true;
		}
	}
	
}
