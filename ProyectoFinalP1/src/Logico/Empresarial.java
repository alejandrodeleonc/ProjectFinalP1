package Logico;

import java.util.ArrayList;

public class Empresarial extends Cliente {
	
	private String nombreEmpresa;
	private double rnc;
	public Empresarial(int codigo, String nombre, double telefono, String direccion, String nombreEmpresa, double rnc) {
		super(codigo, nombre, telefono, direccion);
		this.nombreEmpresa = nombreEmpresa;
		this.rnc = rnc;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	public double getRnc() {
		return rnc;
	}
	public void setRnc(double rnc) {
		this.rnc = rnc;
	}
	
}
