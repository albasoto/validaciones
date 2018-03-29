package entidades;

/**
 * @author alba
 *
 */
public class Proveedor extends Persona {

	String razonSocial, estado, mensaje;

	/**
	 * @param identificacion
	 * @param razonSocial
	 * @param emal1
	 * @param telefono
	 * @param nombre
	 * @param apellido
	 * @param email2
	 * @param celular
	 * @param direccion
	 * @param estado
	 * @param mensaje
	 */
	public Proveedor(String identificacion, String razonSocial, String emal1, String telefono, String nombre,
			String apellido, String email2, String celular, String direccion, String estado, String mensaje) {
		super(identificacion, nombre, apellido, emal1, email2, telefono, celular, direccion);
		this.razonSocial = razonSocial;
		this.estado = estado;
		this.mensaje = mensaje;

	}

	public Proveedor(String identificacion) {
		super(identificacion);
		// TODO Auto-generated constructor stub
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
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
