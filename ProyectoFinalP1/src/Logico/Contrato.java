package Logico;

import java.util.ArrayList;

public class Contrato {

	private Empleado miEmpleado;
	private Cliente miCliente;
	private ArrayList<Plan>misPlanes;
	private float precioTotal;
	
	public Contrato(Empleado miEmpleado, Cliente miCliente, ArrayList<Plan> misPlanes, float precioTotal) {
		super();
		this.miEmpleado = miEmpleado;
		this.miCliente = miCliente;
		this.misPlanes = misPlanes;
		this.precioTotal = precioTotal;
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
	public void setMisPlanes(ArrayList<Plan> misPlanes) {
		this.misPlanes = misPlanes;
	}
	public float getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}
	
}
