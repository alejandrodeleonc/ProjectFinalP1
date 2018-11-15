package Logico;

import java.util.ArrayList;

public class Tricom {
	
	private ArrayList<Cliente> misClientes;
	private ArrayList<Empleado> misEmpleados;
	private ArrayList<Plan> misPlanes;
	private ArrayList<Contrato> misContratos;
	private static Tricom tricom;
	
	private Tricom() {
		super();
		this.misClientes = new ArrayList<>();
		this.misEmpleados = new ArrayList<>();
		this.misPlanes = new ArrayList<>();
		this.misContratos = new ArrayList<>();
	}
	public static Tricom getInstance() {
		if(tricom == null) {
			tricom = new Tricom();
		}
		return tricom;
	}
	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}
	public void setMisClientes(Cliente cliente) {
		this.misClientes.add(cliente);
	}
	public ArrayList<Empleado> getMisEmpleados() {
		return misEmpleados;
	}
	public void setMisEmpleados(Empleado empleado) {
		this.misEmpleados.add(empleado);
	}
	public ArrayList<Plan> getMisPlanes() {
		return misPlanes;
	}
	public void setMisPlanes(Plan plan) {
		this.misPlanes.add(plan);
	}
	public ArrayList<Contrato> getMisContratos() {
		return misContratos;
	}
	public void setMisContratos(Contrato contrato) {
		this.misContratos.add(contrato);
	}
	
}

