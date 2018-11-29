package Logico;

import java.util.ArrayList;

public class Tricom {
	
	private ArrayList<Cliente> clientes;
	private ArrayList<Empleado> empleados;
	private ArrayList<Plan> planes;
	private ArrayList<Contrato> contratos;
	private static Tricom tricom;
	
	private Tricom() {
		super();
		this.clientes = new ArrayList<>();
		this.empleados = new ArrayList<>();
		this.planes = new ArrayList<>();
		this.contratos = new ArrayList<>();
	}
	public static Tricom getInstance() {
		if(tricom == null) {
			tricom = new Tricom();
		}
		return tricom;
	}
	public ArrayList<Cliente> getMisClientes() {
		return clientes;
	}
	public void setMisClientes(Cliente cliente) {
		this.clientes.add(cliente);
	}
	public ArrayList<Empleado> getMisEmpleados() {
		return empleados;
	}
	public void setMisEmpleados(Empleado empleado) {
		this.empleados.add(empleado);
	}
	public ArrayList<Plan> getMisPlanes() {
		return planes;
	}
	public void setMisPlanes(Plan plan) {
		this.planes.add(plan);
	}
	public ArrayList<Contrato> getMisContratos() {
		return contratos;
	}
	public void setMisContratos(Contrato contrato) {
		this.contratos.add(contrato);
	}
	public Cliente findclientbycode(int code) {
		// TODO Auto-generated method stub
		 Cliente aux = null;
		 boolean find = false;
		 int i = 0;
		 while( i < clientes.size() && !find){
			 if(clientes.get(i).getCodigo() == code)
			 {
				 aux = clientes.get(i);
				 find = true;
				 
			  }
			 i++;
			 }
		 return aux;
	 }

	public Empleado findpersonalbyname (String nombre) {
		
		 Empleado aux = null;
		 boolean find = false;
		 int i = 0;
		 while( i < empleados.size() && !find){
			 if(empleados.get(i).getNombre().equalsIgnoreCase(nombre))
			 {
				 find = true;
				 aux = empleados.get(i);
			  }
			 i++;
			 }
		 return aux;
	 }

	public Plan findplanbycode (String name) {
		
		 Plan aux = null;
		 boolean find = false;
		 int i = 0;
		 while( i < planes.size() && !find){
			 if(planes.get(i).getNombrePlan().equalsIgnoreCase(name))
			 {
				 find = true;
				 aux = planes.get(i);
			  }
			 i++;
			 }
		 return aux;
	 }
	public void updatePersonal(Empleado aux1) {
		int index = 0;
		int i=0;
		boolean find = false;
		while (!find && i<empleados.size()) {
			if(empleados.get(i).getNombre().equalsIgnoreCase(aux1.getNombre())){
				find = true;
				index = i;
			}
		}
		empleados.set(index,aux1);
	} 
	
	

	public void updateclient(Cliente aux1) {
		int index = 0;
		int i=0;
		boolean find = false;
		while (!find && i<clientes.size()) {
			if(clientes.get(i).getNombre().equalsIgnoreCase(aux1.getNombre())){
				find = true;
				index = i;
			}
		}
		clientes.set(index,aux1);
	}

	public void updatePlan(Plan plan) {
		int index = 0;
		int i=0;
		boolean find = false;
		while (!find && i<planes.size()) {
			if(planes.get(i).getNombrePlan().equalsIgnoreCase(plan.getNombrePlan())){
				find = true;
				index = i;
			}
		}
		planes.set(index,plan);
	}


}

