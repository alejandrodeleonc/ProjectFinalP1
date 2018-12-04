package Logico;

import java.util.ArrayList;
import java.io.Serializable;
public class Contrato  implements Serializable{
	
	private int codigo;
	private Empleado miEmpleado;
	private Cliente miCliente;
	private ArrayList<Plan>misPlanes;
	private double precioneto;
	private double precioBruto;
	public Contrato(int codigo, Empleado miEmpleado, Cliente miCliente, ArrayList<Plan> misPlanes) {
		super();
		this.codigo = codigo;
		this.miEmpleado = miEmpleado;
		this.miCliente = miCliente;
		this.misPlanes = misPlanes;
		this.precioneto = setPrecioneto();
		this.precioBruto = setPrecioBruto();
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	public void setMisPlanes(Plan plan) {
		this.misPlanes.add(plan);
	}
	public double getPrecioneto() {
		return precioneto;
	}
	public double setPrecioneto() {
		double total = 0 ;
		for(int i =0; i<misPlanes.size();i++){
			total += misPlanes.get(i).getPrecio();
		}
		return total;
	}
	public double getPrecioBruto() {
		return precioBruto;
	}
	
	//Metodo para obtener precio total a pagar.
	public double setPrecioBruto() {
		double total;
		total = (this.precioneto * 1.3);
		return total;
	}
	
	
	
	
	
	
}
