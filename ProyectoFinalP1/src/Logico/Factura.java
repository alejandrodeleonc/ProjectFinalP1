package Logico;

import java.util.Date;
import java.io.Serializable;
public class Factura implements Serializable {
	
	private int codigo;
	private double precioneto;
	private double preciobruto;
	private boolean estado;
	private Date fechaEmision;
	private Cliente miCliente;
	public Factura(int codigo, double precioneto, double preciobruto, boolean estado, Date fechaEmision,
			Cliente miCliente) {
		super();
		this.codigo = codigo;
		this.precioneto = precioneto;
		this.preciobruto = preciobruto;
		this.estado = estado;
		this.fechaEmision = fechaEmision;
		this.miCliente = miCliente;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public double getPrecioneto() {
		return precioneto;
	}
	public void setPrecioneto(double precioneto) {
		this.precioneto = precioneto;
	}
	public double getPreciobruto() {
		return preciobruto;
	}
	public void setPreciobruto(double preciobruto) {
		this.preciobruto = preciobruto;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public Date getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public Cliente getMiCliente() {
		return miCliente;
	}
	public void setMiCliente(Cliente miCliente) {
		this.miCliente = miCliente;
	}
	
}
