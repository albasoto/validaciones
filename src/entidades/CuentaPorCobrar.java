package entidades;

/**
 * @author alba
 *
 */
public class CuentaPorCobrar {

	UnidadHabitacional unidadHabitacional;
	String rubro, fechaEmision, fechaVencimiento, numeroDocumento, detalle, valor, modo, estado, mensaje;;

	/**
	 * @param unidadHabitacional
	 * @param rubro
	 * @param fechaEmision
	 * @param fechaVencimiento
	 * @param numeroDocumento
	 * @param detalle
	 * @param valor
	 * @param modo
	 * @param estado
	 * @param mensaje
	 */
	public CuentaPorCobrar(UnidadHabitacional unidadHabitacional, String rubro, String fechaEmision,
			String fechaVencimiento, String numeroDocumento, String detalle, String valor, String modo, String estado,
			String mensaje) {
		super();
		this.unidadHabitacional = unidadHabitacional;
		this.rubro = rubro;
		this.fechaEmision = fechaEmision;
		this.fechaVencimiento = fechaVencimiento;
		this.numeroDocumento = numeroDocumento;
		this.detalle = detalle;
		this.valor = valor;
		this.modo = modo;
		this.estado = estado;
		this.mensaje = mensaje;
	}

	public UnidadHabitacional getUnidadHabitacional() {
		return unidadHabitacional;
	}

	public void setUnidadHabitacional(UnidadHabitacional unidadHabitacional) {
		this.unidadHabitacional = unidadHabitacional;
	}

	public String getRubro() {
		return rubro;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
	}

	public String getModo() {
		return modo;
	}

	public void setModo(String modo) {
		this.modo = modo;
	}

	public String getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
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
