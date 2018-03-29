package entidades;

/**
 * @author alba
 *
 */
public class UnidadHabitacional {

	String id, tipo;
	String area, alicuota, valorExpensa, valorSeguro;
	String ubicacion;
	String tefono;
	String estaArrendado, estaOcupado;
	String estado, mensaje;

	/**
	 * @param tipo
	 * @param id
	 * @param area
	 * @param alicuota
	 * @param valorExpensa
	 * @param valorSeguro
	 * @param ubicacion
	 * @param tefono
	 * @param estaArrendado
	 * @param estaOcupado
	 * @param estado
	 * @param mensaje
	 */
	public UnidadHabitacional(

			String tipo, String id, String area, String alicuota, String valorExpensa, String valorSeguro,
			String ubicacion, String tefono, String estaArrendado, String estaOcupado, String estado, String mensaje) {

		this.tipo = tipo;
		this.id = id;
		this.area = area;
		this.alicuota = alicuota;
		this.valorExpensa = valorExpensa;
		this.valorSeguro = valorSeguro;
		this.ubicacion = ubicacion;
		this.tefono = tefono;
		this.estaArrendado = estaArrendado;
		this.estaOcupado = estaOcupado;
		this.estado = estado;
		this.mensaje = mensaje;
	}

	public UnidadHabitacional(String id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAlicuota() {
		return alicuota;
	}

	public void setAlicuota(String alicuota) {
		this.alicuota = alicuota;
	}

	public String getValorExpensa() {
		return valorExpensa;
	}

	public void setValorExpensa(String valorExpensa) {
		this.valorExpensa = valorExpensa;
	}

	public String getValorSeguro() {
		return valorSeguro;
	}

	public void setValorSeguro(String valorSeguro) {
		this.valorSeguro = valorSeguro;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getTefono() {
		return tefono;
	}

	public void setTefono(String tefono) {
		this.tefono = tefono;
	}

	public String getEstaArrendado() {
		return estaArrendado;
	}

	public void setEstaArrendado(String estaArrendado) {
		this.estaArrendado = estaArrendado;
	}

	public String getEstaOcupado() {
		return estaOcupado;
	}

	public void setEstaOcupado(String estaOcupado) {
		this.estaOcupado = estaOcupado;
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
