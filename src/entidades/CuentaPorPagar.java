package entidades;

/**
 * @author alba
 *
 */
public class CuentaPorPagar {

	Proveedor proveedor;

	String rubro, fechaFactura, fechaVencimiento, numeroFactura, detalle, valorPorPagar, estado, mensaje;

	/**
	 * @param proveedor
	 * @param rubro
	 * @param fechaFactura
	 * @param fechaVencimiento
	 * @param numeroFactura
	 * @param detalle
	 * @param valorPorPagar
	 * @param estado
	 * @param mensaje
	 */
	public CuentaPorPagar(Proveedor proveedor, String rubro, String fechaFactura, String fechaVencimiento,
			String numeroFactura, String detalle, String valorPorPagar, String estado, String mensaje) {
		super();
		this.proveedor = proveedor;
		this.rubro = rubro;
		this.fechaFactura = fechaFactura;
		this.fechaVencimiento = fechaVencimiento;
		this.numeroFactura = numeroFactura;
		this.detalle = detalle;
		this.valorPorPagar = valorPorPagar;
		this.estado = estado;
		this.mensaje = mensaje;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public String getRubro() {
		return rubro;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
	}

	public String getFechaFactura() {
		return fechaFactura;
	}

	public void setFechaFactura(String fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getValorPorPagar() {
		return valorPorPagar;
	}

	public void setValorPorPagar(String valorPorPagar) {
		this.valorPorPagar = valorPorPagar;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
