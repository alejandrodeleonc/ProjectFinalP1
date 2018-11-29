package Logico;

public abstract class Empleado {
	
	protected String nombre;
	protected String apellido;
	protected String direccion;
	protected String cedula;
	protected String cargo;
	protected float salario;
	protected String fechadeNacimiento;
	protected String fechadeIngreso;
	
	public Empleado(String nombre, String apellido, String direccion, String cedula, String cargo, float salario,
			String fechadeNacimiento, String fechadeIngreso) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.salario = salario;
		this.cedula = cedula;
		this.cargo = cargo;
		this.fechadeNacimiento = fechadeNacimiento;
		this.fechadeIngreso = fechadeIngreso;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getFechadeNacimiento() {
		return fechadeNacimiento;
	}
	public void setFechadeNacimiento(String fechadeNacimiento) {
		this.fechadeNacimiento = fechadeNacimiento;
	}
	public String getFechadeIngreso() {
		return fechadeIngreso;
	}
	public void setFechadeIngreso(String fechadeIngreso) {
		this.fechadeIngreso = fechadeIngreso;
	}	
}
