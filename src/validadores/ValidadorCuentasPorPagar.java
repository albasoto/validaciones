package validadores;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import entidades.CuentaPorCobrar;
import entidades.CuentaPorPagar;
import entidades.Proveedor;
import entidades.UnidadHabitacional;

public class ValidadorCuentasPorPagar {
	
public String validarCuentasPorPagar(CuentaPorPagar cuentaxPagar, List<CuentaPorPagar> listaCuentaxPagar, List<Proveedor> provedores) {
		
		String resultado="";
		
		String mensajeSiExisteProveedor= existeProveedor(cuentaxPagar, provedores);
		if (mensajeSiExisteProveedor!="") {
			resultado+=mensajeSiExisteProveedor+"\n";
		} 
		
		String mensajeCamposObligatorios= comprobarNulosCuentasPorPagar(cuentaxPagar);
		if (mensajeCamposObligatorios!="") {
			resultado+=mensajeCamposObligatorios+"\n";
		} 
		String mensajeValidarFecha= Validarfecha(cuentaxPagar);
		if (mensajeValidarFecha!="") {
			resultado+=mensajeValidarFecha+"\n";
		} 
	
		return resultado;
	
	}
	
	
	/**
	 * @param cuentaxPagar
	 * @param listaProveedor
	 * @return
	 */
	public String existeProveedor(CuentaPorPagar cuentaxPagar, List<Proveedor> listaProveedor) {

		Boolean siExisteUnidad = false;

		for (Proveedor provedores : listaProveedor) {
			if (provedores.getIdentificacion() == cuentaxPagar.getProveedor().getIdentificacion()) {
				siExisteUnidad = true;
			}
		}

		if (siExisteUnidad) {
			return "";
		} else {
			return "-No existe proveedor";
		}

	}

	/**
	 * @param cuentaxPagar
	 * @return
	 */
	public String comprobarNulosCuentasPorPagar(CuentaPorPagar cuentaxPagar) {
		String resultado = "";

		if (cuentaxPagar.getProveedor().getIdentificacion()== null) {
			resultado += "-\n ID Proveedor VACIO";
		}
		if (cuentaxPagar.getRubro() == "") {
			resultado += "-\n Rubro VACIO";
		}
		if (cuentaxPagar.getFechaFactura() == "") {
			resultado += "-\n Fecha factura VACIO";
		}
		if (cuentaxPagar.getFechaVencimiento() == "") {
			resultado += "-\n Fecha de vencimiento VACIO";
		}
		if (cuentaxPagar.getNumeroFactura() == "") {
			resultado += "-\n Numero de factura VACIO";
		}
		if (cuentaxPagar.getDetalle() == "") {
			resultado += "-\n Detalle de factura VACIO";
		}
		if (cuentaxPagar.getValorPorPagar() == "") {
			resultado += "-\n Valor a pagar VACIO";
		}

		return resultado;
	}
public String Validarfecha(CuentaPorPagar pagar) {
		
		Boolean formato = false;
		String fechaFactura = pagar.getFechaFactura();
		String fechaVencimiento = pagar.getFechaVencimiento();
		if (fechaFactura.matches("^\\d{4}([\\-/.])(0?[1-9]|1[1-2])\\1(3[01]|[12][0-9]|0?[1-9])$")
				&& fechaVencimiento.matches("^\\d{4}([\\-/.])(0?[1-9]|1[1-2])\\1(3[01]|[12][0-9]|0?[1-9])$")) {
			formato = true;
		}
		if (formato) {		
			String resultado = "";
			try {
				SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
				Date factura = formateador.parse(fechaFactura);
				Date vencimiento = formateador.parse(fechaVencimiento);

				if (factura.before(vencimiento)) {
					resultado = "";
				} else {
					if (vencimiento.before(factura)) {
						resultado = "-Fecha factura mayor ";
					} else {
						resultado = "-Las Fechas Son iguales ";
					}
				}
			} catch (Exception e) {

				return "-Fecha invalida";
			}
			return resultado;
		} else {
			return "-Fecha invalida";
		}
	}

}
