package validadores;

import java.util.List;

import entidades.ParqueaderoBodega;
import entidades.UnidadHabitacional;

public class ValidadorParqueaderoBodega {
	
	public String validarParquedero(ParqueaderoBodega parqueadero, List<ParqueaderoBodega> listaParquedro, List<UnidadHabitacional> unidades) {
		
		String resultado="";
		
		String mensajeSiExisteUnidad= existeUnidad(parqueadero,unidades);
		if (mensajeSiExisteUnidad!="") {
			resultado+=mensajeSiExisteUnidad+"\n";
		} 
		
		String comprobarRepiteParqueadero=comprobarSiSeRepiteParqueadero(parqueadero,listaParquedro);
		if (comprobarRepiteParqueadero!="") {
			resultado+=comprobarRepiteParqueadero+"\n";
		} 
		String camposObligatorios=comprobarNulosParqueadero(parqueadero);
		if (camposObligatorios!="") {
			resultado+=camposObligatorios+"\n";
		
		}
		
		
		return resultado;
	
	}

public String validarBodega(ParqueaderoBodega parqueadero, List<ParqueaderoBodega> listaParquedro, List<UnidadHabitacional> unidades) {
		
		String resultado="";
		
		String mensajeSiExisteUnidad= existeUnidad(parqueadero,unidades);
		if (mensajeSiExisteUnidad!="") {
			resultado+=mensajeSiExisteUnidad+"\n";
		} 
		
		String comprobarRepiteBodega=comprobarSiSeRepiteBodega(parqueadero,listaParquedro);
		if (comprobarRepiteBodega!="") {
			resultado+=comprobarRepiteBodega+"\n";
		} 
		String camposObligatorios=comprobarNulosParqueadero(parqueadero);
		if (camposObligatorios!="") {
			resultado+=camposObligatorios+"\n";
		
		}
		
		
		return resultado;
	
	}

	
	/**
	 * @param parqueaderoBodega
	 * @param listaUnidad
	 * @return
	 */
	public String existeUnidad(ParqueaderoBodega parqueaderoBodega, List<UnidadHabitacional> listaUnidad) {

		Boolean siExisteUnidad = false;

		for (UnidadHabitacional unidadHabitacional : listaUnidad) {
			if (unidadHabitacional.getId() == parqueaderoBodega.getUnidadHabitacional().getId()) {
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
	 * @param parqueadero
	 * @param listaParqueadero
	 * @return
	 */
	public String comprobarSiSeRepiteParqueadero(ParqueaderoBodega parqueadero,
			List<ParqueaderoBodega> listaParqueadero) {
		int aux = 0;
		for (ParqueaderoBodega parqueaderos : listaParqueadero) {
			if (parqueaderos.getId() == parqueadero.getId()) {
				aux++;
			}
		}
		if (aux > 1) {
			return "-El parqueadero "+"'"+parqueadero.getId()+"'"+" se repetite " + aux + " veces \n";
		} else {
			return "";
		}
	}
	public String comprobarSiSeRepiteBodega(ParqueaderoBodega parqueadero,
			List<ParqueaderoBodega> listaParqueadero) {
		int aux = 0;
		for (ParqueaderoBodega bodegas : listaParqueadero) {
			if (bodegas.getId() == bodegas.getId()) {
				aux++;
			}
		}
		if (aux > 1) {
			return "-La bodega "+"'"+parqueadero.getId()+"'"+" se repetite " + aux + " veces \n";
		} else {
			return "";
		}
	}

	/**
	 * @param parqueadero
	 * @return
	 */
	public String comprobarNulosParqueadero(ParqueaderoBodega parqueadero) {
		String resultado = "";
		if (parqueadero.getUnidadHabitacional().getId() == null) {
			resultado += "-ID Unidad habitacional VACIO \n";
		}

		
		if (parqueadero.getId() == "") {
			resultado += "-Identificación VACIO \n";
		}

		return resultado;
	}

}
