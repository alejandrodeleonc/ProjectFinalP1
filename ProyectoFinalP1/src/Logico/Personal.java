package Logico;

import java.util.ArrayList;

public class Personal extends Cliente {

	private String cedula;
	
	public Personal(String nombre, String apellido, String direccion, String telefono, String fechadeNacimiento,
			String fechadeIngreso, ArrayList<Plan> misPlanes, String cedula) {
		super(nombre, apellido, direccion, telefono, fechadeNacimiento, fechadeIngreso);
		this.cedula = cedula;
	}
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
}
