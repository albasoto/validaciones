package entidades;

/**
 * @author alba
 *
 */
public class ParqueaderoBodega {
	UnidadHabitacional unidadHabitacional;
	String id, estaArrendada, ubicacion, estado, mensaje;

	/**
	 * @param unidadHabitacional
	 * @param id
	 * @param estaArrendada
	 * @param ubicacion
	 * @param estado
	 * @param mensaje
	 */
	public ParqueaderoBodega(UnidadHabitacional unidadHabitacional, String id, String estaArrendada, String ubicacion,
			String estado, String mensaje) {
		super();
		this.unidadHabitacional = unidadHabitacional;
		this.id = id;
		this.estaArrendada = estaArrendada;
		this.ubicacion = ubicacion;
		this.estado = estado;
		this.mensaje = mensaje;
	}

	public UnidadHabitacional getUnidadHabitacional() {
		return unidadHabitacional;
	}

	public void setUnidadHabitacional(UnidadHabitacional unidadHabitacional) {
		this.unidadHabitacional = unidadHabitacional;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public String getEstaArrendada() {
		return estaArrendada;
	}

	public void setEstaArrendada(String estaArrendada) {
		this.estaArrendada = estaArrendada;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
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
