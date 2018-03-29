package entidades;

/**
 * @author alba
 *
 */
public class Contacto extends Persona {
	UnidadHabitacional unidadHabitacional;
	String relacion, viveEnUnidad, esRepresentante, estado, mensaje;

	/**
	 * @param unidadHabitacional
	 * @param identificacion
	 * @param relacion
	 * @param nombre
	 * @param apellido
	 * @param emal1
	 * @param email2
	 * @param celular
	 * @param telefono
	 * @param viveEnUnidad
	 * @param esRepresentante
	 * @param estado
	 * @param mensaje
	 */
	public Contacto(UnidadHabitacional unidadHabitacional, String identificacion, String relacion, String nombre,
			String apellido, String emal1, String email2, String celular, String telefono, String viveEnUnidad,
			String esRepresentante, String estado, String mensaje) {
		super(identificacion, nombre, apellido, emal1, email2, telefono, celular);
		this.unidadHabitacional = unidadHabitacional;
		this.relacion = relacion;
		this.viveEnUnidad = viveEnUnidad;
		this.esRepresentante = esRepresentante;
		this.estado = estado;
		this.mensaje = mensaje;
	}

	public UnidadHabitacional getUnidadHabitacional() {
		return unidadHabitacional;
	}

	public void setUnidadHabitacional(UnidadHabitacional unidadHabitacional) {
		this.unidadHabitacional = unidadHabitacional;
	}

	public String getRelacion() {
		return relacion;
	}

	public void setRelacion(String relacion) {
		this.relacion = relacion;
	}

	public String getViveEnUnidad() {
		return viveEnUnidad;
	}

	public void setViveEnUnidad(String viveEnUnidad) {
		this.viveEnUnidad = viveEnUnidad;
	}

	public String getEsRepresentante() {
		return esRepresentante;
	}

	public void setEsRepresentante(String esRepresentante) {
		this.esRepresentante = esRepresentante;
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
