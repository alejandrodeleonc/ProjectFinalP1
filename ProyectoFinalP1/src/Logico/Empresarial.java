package Logico;

import java.util.ArrayList;

public class Empresarial extends Cliente {
	
	private double rnc;
	private String nombreEmpresa;
	
	public Empresarial(String nombre, String apellido, String direccion, String telefono, String fechadeNacimiento,
			String fechadeIngreso, ArrayList<Plan> misPlanes, double rnc, String nombreEmpresa) {
		super(nombre, apellido, direccion, telefono, fechadeNacimiento, fechadeIngreso, misPlanes);
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
