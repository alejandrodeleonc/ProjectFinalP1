package Logico;

import java.util.ArrayList;

public class Empresarial extends Cliente {
	
	private double rnc;
	private String nombreEmpresa;
	
	public Empresarial(int codigo, String nombre, String apellido, String direccion, String telefono, String fechadeNacimiento,
			String fechadeIngreso, double rnc, String nombreEmpresa) {
		super(codigo, nombre, apellido, direccion, telefono, fechadeNacimiento, fechadeIngreso);
		this.rnc = rnc;
		this.nombreEmpresa = nombreEmpresa;
	}

	public double getRnc() {
		return rnc;
	}
	public void setRnc(double rnc) {
		this.rnc = rnc;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

}
