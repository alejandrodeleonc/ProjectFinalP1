package Logico;
import java.io.Serializable;
public class Plan implements Serializable{
	
	private int codigo;
	private String nombrePlan;
	private boolean telefono;
	private boolean tv;
	private boolean internet;
	private int cantMinutos;
	private int cantCanales;
	private int cantInternet;
	private double precio;
	public Plan(int codigo, String nombrePlan, boolean telefono, boolean tv, boolean internet, int cantMinutos,
			int cantCanales, int cantInternet, double precio) {
		super();
		this.codigo = codigo;
		this.nombrePlan = nombrePlan;
		this.telefono = telefono;
		this.tv = tv;
		this.internet = internet;
		this.cantMinutos = cantMinutos;
		this.cantCanales = cantCanales;
		this.cantInternet = cantInternet;
		this.precio = precio;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombrePlan() {
		return nombrePlan;
	}
	public void setNombrePlan(String nombrePlan) {
		this.nombrePlan = nombrePlan;
	}
	public boolean isTelefono() {
		return telefono;
	}
	public void setTelefono(boolean telefono) {
		this.telefono = telefono;
	}
	public boolean isTv() {
		return tv;
	}
	public void setTv(boolean tv) {
		this.tv = tv;
	}
	public boolean isInternet() {
		return internet;
	}
	public void setInternet(boolean internet) {
		this.internet = internet;
	}
	public int getCantMinutos() {
		return cantMinutos;
	}
	public void setCantMinutos(int cantMinutos) {
		this.cantMinutos = cantMinutos;
	}
	public int getCantCanales() {
		return cantCanales;
	}
	public void setCantCanales(int cantCanales) {
		this.cantCanales = cantCanales;
	}
	public int getCantInternet() {
		return cantInternet;
	}
	public void setCantInternet(int cantInternet) {
		this.cantInternet = cantInternet;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	//Esto es una prueba de funcionamiento.
		
	
}
