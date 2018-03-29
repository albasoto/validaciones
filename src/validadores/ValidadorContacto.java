

package validadores;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controladores.ControladorContacto;
import entidades.Contacto;
import entidades.CuentaPorCobrar;
import entidades.UnidadHabitacional;

/**
 * @author alba
 *
 */
public class ValidadorContacto {

	/**
	 * Validar contacto.
	 *
	 * @param contacto the contacto
	 * @param contactos the contactos
	 * @param unidades the unidades
	 * @return the string
	 */
	public String validarContacto(Contacto contacto, List<Contacto> contactos, List<UnidadHabitacional> unidades) {

		String resultado="";

		String mensajeSiExisteUnidad= existeUnidad(contacto, unidades);
		if (mensajeSiExisteUnidad!="") {
			resultado+=mensajeSiExisteUnidad+"\n";
		} 

		String mensajeCamposObligatorios= comprobarNulosContacto(contacto);
		if (mensajeCamposObligatorios!="") {
			resultado+=mensajeCamposObligatorios+"\n";
		} 

		String mensajeTamañoIdentificacion= LonguitudIdentificacion(contacto);
		if (mensajeTamañoIdentificacion!="") {
			resultado+=mensajeTamañoIdentificacion+"\n";
		}

		String mensajeTelefono= validarConvencional(contacto);
		if (mensajeTelefono!="") {
			resultado+=mensajeTelefono+"\n";
		}

		String mensajeCelular= validarCelular(contacto);
		if (mensajeCelular!="") {
			resultado+=mensajeCelular+"\n";
		}
		
			
		return resultado;

	}


	/**
	 * @param contacto
	 * @param listaUnidad
	 * @return mensaje si existe unidad 
	 */
	public String existeUnidad(Contacto contacto, List<UnidadHabitacional> listaUnidad) {

		Boolean siExisteUnidad = false;

		for (UnidadHabitacional unidadHabitacional : listaUnidad) {
			if (unidadHabitacional.getId() == contacto.getUnidadHabitacional().getId()) {
				siExisteUnidad = true;
			}
		}

		if (siExisteUnidad) {
			return "";
		} else {
			return "-No existe la unidad habitacional '" + contacto.getUnidadHabitacional().getId()+"'";
		}

	}

	/**
	 * @param contacto
	 * @return
	 */
	public String comprobarNulosContacto(Contacto contacto) {
		String resultado = "";

		if (contacto.getUnidadHabitacional().getId() == null) {
			resultado += "-ID Unidad habitacional VACIO \n";
		}

		if (contacto.getIdentificacion() == "") {
			resultado += "-cedula/RUC/Pasaporte VACIO \n" ;
		}
		if (contacto.getRelacion() == "") {
			resultado += "-Relacion VACIO \n";
		}
		if (contacto.getNombre() == "") {
			resultado += "-Nombre VACIO \n";
		}

		if (contacto.getApellido() == "") {
			resultado += "-Apellido VACIO \n";
		}

		if (contacto.getEsRepresentante() == "") {
			resultado += "-Representante VACIO \n";
		}

		return resultado;
	}

	/**
	 * @param contacto
	 * @param contactos
	 * @return
	 */
	public String UnicoPropietario(Contacto contacto, List<Contacto> contactos) {

		int aux = 0;

		String id = contacto.getUnidadHabitacional().getId();

		//System.out.println(id);

		for (Contacto contac : contactos) {


			if (contac.getUnidadHabitacional().getId() == id && contac.getRelacion()=="Propietario") {
				System.out.println("true");
				aux++;
			}

		}

		if (aux > 1) {

			int total = aux - 1;
			return "-El propietario se repite " + total + "veces";
		} else {
			return "";
		}
	}


	/**
	 * Longuitud identificacion.
	 *
	 * @param contactos the contactos
	 * @return the string
	 */
	public String LonguitudIdentificacion(Contacto contactos) {

		String resultado = "";
		String identificacion = contactos.getIdentificacion();

		if (identificacion.length() >= 15) {
			resultado += "-La identificaion tiene mas de 15 caracteres";

		}

		return resultado;
	}

	/**
	 * @param contacto
	 * @return
	 */
	public String validarConvencional(Contacto contacto) {
		String resultado = "";

		String telefono = contacto.getTelefono().replace(".", "");
		if (telefono.length() == 0) {
			resultado = "";
		}
		else if (telefono.length() < 7) {
			resultado = "-El telefono no puede tener menos de 7 caracteres";
		} else if (telefono.length() > 10) {
			resultado = "-El telefono no puede tener mas de 9 caracteres";
		}

		return resultado;

	}

	/**
	 * @param contacto
	 * @return
	 */
	public String validarCelular(Contacto contacto) {
		String resultado = "";

		String celular = contacto.getCelular().replace(".", "");
		if (celular.length() == 0) {
			resultado = "";
		}
		else if (celular.length() < 10) {
			resultado = "-Celular no tiene 10 digitos";
		} else if (celular.length() > 10){
			resultado = "-Celular tiene mas de 10 digitos ";
		}

		return resultado;

	}

	public Contacto crearIdentificacion(Contacto contacto, String unidad, String oid) {

		if (contacto.getIdentificacion().equals("")) {
			contacto.setIdentificacion(unidad+"-"+oid+"-"+contacto.getUnidadHabitacional().getId().toLowerCase());
			contacto.setMensaje("-Identificación generada\n");
			return contacto;
		}
		return null;
	}


	
/*	public static boolean ValidarCorreo(String email) {

		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		// String regex= "\\\\d{8}[A-HJ-NP-TV-Z]";
		// (\W|^)[\w.\-]{0,25}@(yahoo|hotmail|gmail)\.com(\W|$)

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);

		return matcher.matches();
	}

public String ValidarEmail(Contacto contacto) {
	   Pattern pattern = Pattern.compile("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\\\.[\\\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,6}$");

	    // El email a validar
	   String resultado="";
	    String correo=contacto.getEmal1();

	    Matcher mather = pattern.matcher(correo);

	    if (mather.find() == true) {
	        resultado= "El email ingresado es válido.";
	    } else {
	       resultado="El email ingresado es inválido.";
	    }
	return resultado;
}
*/

}

