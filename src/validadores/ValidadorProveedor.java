package validadores;

import java.util.List;

import entidades.Contacto;
import entidades.ParqueaderoBodega;
import entidades.Proveedor;
import entidades.UnidadHabitacional;

public class ValidadorProveedor {

public String validarProveedor(Proveedor proveedor, List<Proveedor> listaProveedor) {
		
		String resultado="";
		
		String mensajeSiSeRepiteProveedor= comprobarSiSeRepiteProveedor(proveedor,listaProveedor);
		if (mensajeSiSeRepiteProveedor!="") {
			resultado+=mensajeSiSeRepiteProveedor+"\n";
		} 
		
		String mensajeCamposObligatorios=comprobarNulosProveedor(proveedor);
		if (mensajeCamposObligatorios!="") {
			resultado+=mensajeCamposObligatorios+"\n";
		} 
		String mensajelongiçuitudIdentify=longuitudIdentificacionProveedor(proveedor);
		if (mensajelongiçuitudIdentify!="") {
			resultado+=mensajelongiçuitudIdentify+"\n";
		
		}
		String mensajeValidaTelefono=validarConvencional(proveedor);
		if (mensajeValidaTelefono!="") {
			resultado+=mensajeValidaTelefono+"\n";
		
		}
		String mensajeValidaCeulular=validarCelular(proveedor);
		if (mensajeValidaCeulular!="") {
			resultado+=mensajeValidaCeulular+"\n";
		
		}
		return resultado;
	
	}
	/**
	 * @param proveedor
	 * @param listaProveedor
	 * @return
	 */
	public String comprobarSiSeRepiteProveedor(Proveedor proveedor, List<Proveedor> listaProveedor) {
		int aux = 0;
		for (Proveedor proveedores : listaProveedor) {
			if (proveedores.getIdentificacion() == proveedor.getIdentificacion()) {
				aux++;
			}
		}
		if (aux > 1) {
			return "-El proveedor "+"'"+proveedor.getIdentificacion()+"'"+" se repetite " + aux + " veces";
		} else {
			return "";
		}
	}


	/**
	 * @param proveedor
	 * @return
	 */
	public String comprobarNulosProveedor(Proveedor proveedor) {
		String resultado = "";

		if (proveedor.getIdentificacion() == "") {
			resultado += "-Identificacion VACIA \n";
		}
		if (proveedor.getRazonSocial() == "") {
			resultado += "-Razon Social VACIO \n";
		}
		if (proveedor.getTelefono() == "") {
			resultado += "-Telefono VACIO \n";
		}
		if (proveedor.getNombre() == "") {
			resultado += "-Nombre VACIO \n";
		}
		if (proveedor.getApellido() == "") {
			resultado += "-Apellido VACIO \n";
		}

		return resultado;
	}

	/**
	 * @param proveedor
	 * @return
	 */
	public String longuitudIdentificacionProveedor(Proveedor proveedor) {
		String resultado = "";
		String identificacion = proveedor.getIdentificacion();

		if (identificacion.length() >= 15) {
			resultado += "-La identificaion tiene mas de 15 caracteres";

		}

		return resultado;
	}
	
	public String validarConvencional(Proveedor proveedor) {
		String resultado = "";

		String telefono = proveedor.getTelefono().replace(".", "");
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
	public String validarCelular(Proveedor proveedor) {
		String resultado = "";

		String celular = proveedor.getCelular().replace(".", "");
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

}
