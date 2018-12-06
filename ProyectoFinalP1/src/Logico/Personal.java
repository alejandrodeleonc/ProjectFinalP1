package Logico;

import java.util.ArrayList;

public class Personal extends Cliente {
	private double cedula;

	public Personal(int codigo, String nombre, double telefono, String direccion, double cedula) {
		super(codigo, nombre, telefono, direccion);
		this.cedula = cedula;
	}

	public double getCedula() {
		return cedula;
	}

	public void setCedula(double cedula) {
		this.cedula = cedula;
	}
	
	
}
