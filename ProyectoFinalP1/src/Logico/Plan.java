package Logico;

public class Plan {
	
	private String nombrePlan;
	private boolean telefono;
	private boolean tv;
	private boolean internet;
	private double cantMinutos;
	private double cantCanales;
	private double cantInternet;
	
	public Plan(String nombrePlan, boolean telefono, boolean tv, boolean internet, double cantMinutos,
			double cantCanales, double cantInternet) {
		super();
		this.nombrePlan = nombrePlan;
		this.telefono = telefono;
		this.tv = tv;
		this.internet = internet;
		this.cantMinutos = cantMinutos;
		this.cantCanales = cantCanales;
		this.cantInternet = cantInternet;
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
	public double getCantMinutos() {
		return cantMinutos;
	}
	public void setCantMinutos(double cantMinutos) {
		this.cantMinutos = cantMinutos;
	}
	public double getCantCanales() {
		return cantCanales;
	}
	public void setCantCanales(double cantCanales) {
		this.cantCanales = cantCanales;
	}
	public double getCantInternet() {
		return cantInternet;
	}
	public void setCantInternet(double cantInternet) {
		this.cantInternet = cantInternet;
	}
}
