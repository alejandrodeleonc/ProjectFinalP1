package Logico;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;

public class Tricom implements Serializable {

	private ArrayList<Cliente> misClientes;
	private ArrayList<Empleado> misEmpleados;
	private ArrayList<Factura> misFacturas;
	private ArrayList<Plan> misPlanes;
	private ArrayList<Contrato> misContratos;
	private static Tricom tricom;

	// Esto permite tener la clase controladora
	public static Tricom getInstance() {
		if (tricom == null) {
			tricom = new Tricom();
		}

		return tricom;
	}

	private Tricom() {
		super();
		this.misClientes = new ArrayList<>();
		this.misEmpleados = new ArrayList<>();
		this.misFacturas = new ArrayList<>();
		this.misPlanes = new ArrayList<>();
		this.misContratos = new ArrayList<>();
	}

	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}

	public void addClientes(Cliente cliente) {
		this.misClientes.add(cliente);
	}

	public ArrayList<Empleado> getMisEmpleados() {
		return misEmpleados;
	}

	public void addEmpleados(Empleado empleado) {
		this.misEmpleados.add(empleado);
	}

	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}

	public void addFacturas(Factura factura) {
		this.misFacturas.add(factura);
	}

	public ArrayList<Plan> getMisPlanes() {
		return misPlanes;
	}

	public void addPlanes(Plan plan) {
		this.misPlanes.add(plan);
	}

	public ArrayList<Contrato> getMisContratos() {
		return misContratos;
	}

	public void addContratos(Contrato contrato) {
		this.misContratos.add(contrato);
	}

	// Busca un cliente dentro del arreglo, por su codigo.
	public Cliente buscarclienteporcodigo(int code) {
		Cliente aux = null;
		boolean encontrado = false;
		int i = 0;

		while (i < misClientes.size() && !encontrado) {
			if (misClientes.get(i).getCodigo() == code) {
				aux = misClientes.get(i);
				encontrado = true;
			}
			i++;
		}
		return aux;
	}

	// Este metodo busca por cedula o por RNC
	public Cliente buscarporcedulaornc(double c, boolean cedulaOrRnc) {
		Cliente aux = null;
		boolean encontrado = false;
		int i = 0;

		while (i < misClientes.size() && !encontrado) {

			if (cedulaOrRnc == true) {
				if (misClientes.get(i) instanceof Empresarial) {
					if (((Empresarial) misClientes.get(i)).getRnc() == c) {
						aux = misClientes.get(i);
						encontrado = true;
					}
				}
			}
			if (cedulaOrRnc == false) {
				if ((misClientes.get(i) instanceof Personal)) {
					if (((Personal) misClientes.get(i)).getCedula() == c) {
						aux = misClientes.get(i);
						encontrado = true;
					}
				}
			}
			i++;
		}
		return aux;
	}

	// Este busca empleados
	public Empleado buscarempleadoporcodigo(int code) {
		Empleado aux = null;
		boolean encontrado = false;
		int i = 0;

		while (i < misEmpleados.size() && !encontrado) {
			if (misEmpleados.get(i).getCodigo() == code) {
				aux = misEmpleados.get(i);
				encontrado = true;
			}
			i++;
		}
		return aux;
	}

	public int cantidadClientesactivos() {
		int cant = 0;

		for (Cliente cliente : misClientes) {
			if (cliente.getEstado()) {
				cant++;
			}
		}
		return cant;
	}

	// Este metodo edita los empleados
	public void editarEmpleado(Empleado aux) {
		int index = 0;

		index = misEmpleados.indexOf(aux);
		misEmpleados.set(index, aux);
	}

	// Este metodo edita los clientes
	public void editarCliente(Cliente aux) {
		int index = 0;

		index = misClientes.indexOf(aux);
		misClientes.set(index, aux);
	}

	public void editarPlan(Plan aux) {
		int index = 0;

		index = misPlanes.indexOf(aux);
		misPlanes.set(index, aux);
	}

	// Este metodo busca una factura por la cedula de un cliente
	public Factura buscarFacturaporcedornc(double c) {
		Factura aux = null;
		boolean encontrado = false;
		int i = 0;

		while (i < misFacturas.size() && !encontrado) {
			Cliente cliente = misFacturas.get(i).getMiCliente();
			cliente = (Empresarial) cliente;
			if (((Empresarial) cliente).getRnc() == c) {
				aux = misFacturas.get(i);
			} else if (((Personal) cliente).getCedula() == c) {
				aux = misFacturas.get(i);
			}
			i++;
		}
		return aux;
	}

	// Metod de busqueda de contrato mediante cedula o rnc.
	public Contrato buscarContratoporcedulaornc(double c, int id) {
		Contrato aux = null;

		boolean encontrado = false;
		int i = 0;

		while (i < misContratos.size() && !encontrado) {
			Cliente cliente = misContratos.get(i).getMiCliente();
			Empleado emp = misContratos.get(i).getMiEmpleado();
			if (((Empresarial) cliente).getRnc() == c && (emp.getCodigo() == id)) {
				aux = misContratos.get(i);
			} else if (((Personal) cliente).getCedula() == c && (emp.getCodigo() == id)) {
				aux = misContratos.get(i);
			}
			i++;
		}
		return aux;
	}

	public void guardar() {
		FileOutputStream archivo;
		ObjectOutputStream escribir;
		try {
			archivo = new FileOutputStream("datos.dat");
			escribir = new ObjectOutputStream(archivo);
			escribir.writeObject(Tricom.getInstance());
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void cargardatos() {

		try {
			FileInputStream archivo = new FileInputStream("datos.dat");
			ObjectInputStream lectura = new ObjectInputStream(archivo);

			while (true) {
				this.tricom = (Tricom) lectura.readObject();
			}

		} catch (EOFException ex) {
			return;
		} catch (FileNotFoundException ex) {
			System.err.println("Error, " + ex);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void generarfacturas() {
		double precioneto = 0;
		Date fecha = new Date();
		for (Cliente cliente : misClientes) {
			for(int i = 0; i<cliente.getMisPlanes().size(); i++) {
				precioneto +=  cliente.getMisPlanes().get(i).getPrecio();
			}
			Factura f = new Factura(misFacturas.size()+1, precioneto, (precioneto*1.18), false, fecha , cliente);
			Tricom.getInstance().misFacturas.add(f);
		}
	}

}
