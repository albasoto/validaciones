package entidades;

/**
 * @author alba
 *
 */
public class Persona {

	String identificacion, nombre, apellido, emal1, email2, telefono, celular, direccion;

	/**
	 * @param identificacion
	 * @param nombre
	 * @param apellido
	 * @param emal1
	 * @param email2
	 * @param telefono
	 * @param celular
	 * @param direccion
	 */
	public Persona(String identificacion, String nombre, String apellido, String emal1, String email2, String telefono,
			String celular, String direccion) {
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.emal1 = emal1;
		this.email2 = email2;
		this.telefono = telefono;
		this.celular = celular;
		this.direccion = direccion;
	}

	public Persona(String identificacion) {
		super();
		this.identificacion = identificacion;
	}

	public Persona(String identificacion, String nombre, String apellido, String emal1, String email2, String telefono,
			String celular) {
		super();
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.emal1 = emal1;
		this.email2 = email2;
		this.telefono = telefono;
		this.celular = celular;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
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

	public String getEmal1() {
		return emal1;
	}

	public void setEmal1(String emal1) {
		this.emal1 = emal1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
