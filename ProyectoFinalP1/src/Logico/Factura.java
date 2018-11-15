package Logico;

import java.util.ArrayList;

public class Factura {
	
	private Cliente miCliente;
	private ArrayList<Plan> misPlanes = new ArrayList<>();
	
	public Factura(Cliente miCliente, Plan plan) {
		super();
		this.miCliente = miCliente;
		this.misPlanes.add(plan);
	}

	public Cliente getMiCliente() {
		return miCliente;
	}
	public void setMiCliente(Cliente miCliente) {
		this.miCliente = miCliente;
	}
	public ArrayList<Plan> getMisPlanes() {
		return misPlanes;
	}
	public void setMisPlanes(Plan plan) {
		this.misPlanes.add(plan);
	}

}
