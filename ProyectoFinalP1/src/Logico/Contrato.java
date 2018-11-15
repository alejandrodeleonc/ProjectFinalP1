package Logico;

import java.util.ArrayList;

public class Contrato {

	private Empleado miEmpleado;
	private Cliente miCliente;
	private ArrayList<Plan>misPlanes = new ArrayList<>();
	private float precioTotal;
	
	public Contrato(Empleado miEmpleado, Cliente miCliente, Plan miPlan, float precio) {
		super();
		this.miEmpleado = miEmpleado;
		this.miCliente = miCliente;
		this.misPlanes.add(miPlan);
		this.precioTotal = (float)(precio * 1.30);	
		}
	public Empleado getMiEmpleado() {
		return miEmpleado;
	}
	public void setMiEmpleado(Empleado miEmpleado) {
		this.miEmpleado = miEmpleado;
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
	public void setMisPlanes(Plan miPlan) {
		this.misPlanes.add(miPlan);
	}
	public float getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}
	
}
