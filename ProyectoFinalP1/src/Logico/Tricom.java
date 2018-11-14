package Logico;

import java.util.ArrayList;

public class Tricom {
	
	private ArrayList<Cliente> misClientes;
	private ArrayList<Empleado> misEmpleados;
	private ArrayList<Plan> misPlanes;
	
	public Tricom(ArrayList<Cliente> misClientes, ArrayList<Empleado> misEmpleados, ArrayList<Plan> misPlanes) {
		super();
		this.misClientes = misClientes;
		this.misEmpleados = misEmpleados;
		this.misPlanes = misPlanes;
	}
	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}
	public void setMisClientes(ArrayList<Cliente> misClientes) {
		this.misClientes = misClientes;
	}
	public ArrayList<Empleado> getMisEmpleados() {
		return misEmpleados;
	}
	public void setMisEmpleados(ArrayList<Empleado> misEmpleados) {
		this.misEmpleados = misEmpleados;
	}
	public ArrayList<Plan> getMisPlanes() {
		return misPlanes;
	}
	public void setMisPlanes(ArrayList<Plan> misPlanes) {
		this.misPlanes = misPlanes;
	}
}

