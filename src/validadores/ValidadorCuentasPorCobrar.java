package validadores;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.xmlbeans.impl.regex.ParseException;

import entidades.Contacto;
import entidades.CuentaPorCobrar;

import entidades.UnidadHabitacional;

/**
 * @author alba
 *
 */
public class ValidadorCuentasPorCobrar {
public String validarCuentasPorCobrar(CuentaPorCobrar cuentaxCobrar, List<CuentaPorCobrar> listaCuentasPorCobrar, List<UnidadHabitacional> unidades) {
		
		String resultado="";
		
		String mensajeSiExisteUnidad= existeUnidad(cuentaxCobrar, unidades);
		if (mensajeSiExisteUnidad!="") {
			resultado+=mensajeSiExisteUnidad+"\n";
		} 
		
		String mensajeCamposObligatorios= comprobarNulosCuentasPorCobrar(cuentaxCobrar);
		if (mensajeCamposObligatorios!="") {
			resultado+=mensajeCamposObligatorios+"\n";
		} 
		String mensajeValidarFecha= Validarfecha(cuentaxCobrar);
		if (mensajeValidarFecha!="") {
			resultado+=mensajeValidarFecha+"\n";
		} 
	
		return resultado;
	
	}
	
	/**
	 * @param cuentaxCobrar
	 * @param listaUnidad
	 * @return
	 */
	public String existeUnidad(CuentaPorCobrar cuentaxCobrar, List<UnidadHabitacional> listaUnidad) {

		Boolean siExisteUnidad = false;

		for (UnidadHabitacional unidadHabitacional : listaUnidad) {
			if (unidadHabitacional.getId() == cuentaxCobrar.getUnidadHabitacional().getId()) {
				siExisteUnidad = true;
			}
		}

		if (siExisteUnidad) {
			return "";
		} else {
			return "-No existe la unidad habitacional";
		}

	}

	/**
	 * @param cuentasxCobrar
	 * @return
	 */
	public String comprobarNulosCuentasPorCobrar(CuentaPorCobrar cuentasxCobrar) {

		String resultado = "";
		if (cuentasxCobrar.getUnidadHabitacional().getId() == null) {
			resultado += "-\n ID Unidad habitacional VACIO";
		}

				if (cuentasxCobrar.getRubro() == "") {
			resultado += "-\n El rubro VACIO";
		}
		if (cuentasxCobrar.getFechaEmision() == "") {
			resultado += "-\n La fecha de emision VACIO";
		}
		if (cuentasxCobrar.getFechaVencimiento() == "") {
			resultado += "-\n La fecha vencimiento VACIO";
		}
		if (cuentasxCobrar.getDetalle() == "") {
			resultado += "-\n El detalle VACIO";
		}
		if (cuentasxCobrar.getValor() == "") {
			resultado += "-\n El valor VACIO";
		}
		if (cuentasxCobrar.getModo() == "") {
			resultado += "-\n El Modo VACIO";
		}
		return resultado;
	}



	/**
	 * Valida el formato de fecha AÑO-MES-DIA.
	 * Ademas compara la fecha de emision con la fecha vencimiento
	 *
	 * @param cuenta the cuenta
	 * @return the string
	 */
	public String Validarfecha(CuentaPorCobrar cuenta) {
		
		Boolean formato = false;
		String fechaEmision = cuenta.getFechaEmision();
		String fechaVencimiento = cuenta.getFechaVencimiento();
		if (fechaEmision.matches("^\\d{4}([\\-/.])(0?[1-9]|1[1-2])\\1(3[01]|[12][0-9]|0?[1-9])$")
				&& fechaVencimiento.matches("^\\d{4}([\\-/.])(0?[1-9]|1[1-2])\\1(3[01]|[12][0-9]|0?[1-9])$")) {
			formato = true;
		}
		if (formato) {		
			String resultado = "";
			try {
				SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
				Date emision = formateador.parse(fechaEmision);
				Date vencimiento = formateador.parse(fechaVencimiento);

				if (emision.before(vencimiento)) {
					resultado = "";
				} else {
					if (vencimiento.before(emision)) {
						resultado = "-Fecha Emision es MAYOR ";
					} else {
						resultado = "-as Fechas Son iguales ";
					}
				}
			} catch (Exception e) {

				System.out.println("-Se Produjo un Error!!!  " + e.getMessage());
			}
			return resultado;
		} else {
			return "-Fechas invalidas";
		}
	}

}
