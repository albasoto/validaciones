package validadores;

import java.text.DecimalFormat;
import java.util.List;

import entidades.UnidadHabitacional;

public class ValidadorUnidad {
	
	
	
	public String validarUnidad(UnidadHabitacional unidad, List<UnidadHabitacional> unidades) {
		
		String resultado="";
		
		String mensajeSiSeRepite= comprobarSiSeRepiteUnidad(unidad, unidades);
		if (mensajeSiSeRepite!="") {
			resultado+=mensajeSiSeRepite+"\n";
		} 
		
		String mensajeComprobarObligatorios= comprobarNulosUnidad(unidad);
		if (mensajeComprobarObligatorios!="") {
			resultado+=mensajeComprobarObligatorios+"\n";
		}
		
		/*String mensajeSumaAlicoutas= siAlicuotaSuma100(unidades);
		if (mensajeSumaAlicoutas!="") {
			resultado+=mensajeSumaAlicoutas+"\n";
		}*/
		
		String mensajeValidaConvencional= validarConvencional(unidad);
		if (mensajeValidaConvencional!="") {
			resultado+=mensajeValidaConvencional+"\n";
		}
		String mensajeEstaArrendada= estaArrendado(unidad);
		if (mensajeEstaArrendada!="") {
			resultado+=mensajeEstaArrendada+"\n";
		}
		
		return resultado;
	
	}
	
	/* comprueba que la ID UNIDAD HABITACIONAL NO SE REPITA */

	/**
	 * @param unidad
	 * @param listaUnidad
	 * @return
	 */
	public String comprobarSiSeRepiteUnidad(UnidadHabitacional unidad, List<UnidadHabitacional> listaUnidad) {
		int aux = 0;
		for (UnidadHabitacional unidadHabitacional : listaUnidad) {
			if (unidadHabitacional.getId() == unidad.getId()) {
				aux++;
			}
		}
		if (aux > 1) {
			return "-La Unidad habitacional '"+unidad.getId()+"'"+" se repetite " + aux + " veces";
		} else {
			return "";
		}
	}

	
	/**
	 * Comprobar nulos unidad.
	 *
	 * @param unidad the unidad
	 * @return the string
	 */
	public String comprobarNulosUnidad(UnidadHabitacional unidad) {
		
		String resultado = "";

		if (unidad.getId() == "") {
			resultado += "-\n El ID VACIO";
		}

		if (unidad.getValorExpensa() == "") {
			resultado += "-\n Valor expensa VACIO";
		}

		if (unidad.getEstaArrendado() == "") {
			resultado += "-\n Esta arrendada VACIO";
		}

		if (unidad.getEstaOcupado() == "") {
			resultado += "-\n Esta ocupada VACIO";
		}

		return resultado;
	}

	/**
	 * @param unidad
	 * @return
	 */
	public String comprobarDecimales(UnidadHabitacional unidad) {

		String resultado = "";

		if (unidad.getArea() != "") {
			try {
				@SuppressWarnings("unused")
				Double area = Double.parseDouble(unidad.getArea());
			} catch (Exception e) {
				resultado += "-/n El Area no tiene un numero valido";
			}
		}

		return resultado;
	}

	/**
	 * @param unidades
	 * @return
	 */
	public String siAlicuotaSuma100(List<UnidadHabitacional> unidades) {

		Double auxiliar = 0.0;
		String resultado = "";

		for (int i = 0; i < unidades.size(); i++) {
			System.out.println(unidades.get(i).getAlicuota());
			if (unidades.get(i).getAlicuota() != "") {

				auxiliar = Double.parseDouble(unidades.get(i).getAlicuota());
			}
		}

		if (auxiliar == 100) {
			return resultado;
		} else {
			DecimalFormat decimal = new DecimalFormat("#.0000");
			
			return "-El valor de la alicuota suma: " + decimal.format(auxiliar);
		}

	}

	/**
	 * @param unidad
	 * @return
	 */
	public String validarConvencional(UnidadHabitacional unidad) {
		String resultado2 = "";

		String telefono = unidad.getTefono().replace(".", "");
		if (telefono.length() == 0) {
			resultado2 = "";
		}else if
		 (telefono.length() < 7) {
			resultado2 = "-El telefono no puede tener menos de 7 caracteres";
		} else if (telefono.length() > 10) {
			resultado2 = "-El telefono no puede tener mas de 9 caracteres";
		}

		return resultado2;

	}

	/**
	 * @param unidad
	 * @return
	 */
	public String estaArrendado(UnidadHabitacional unidad) {
		String resultado = "";

		if (unidad.getEstaArrendado() == "") {
			unidad.setEstaArrendado("YES");
			resultado = "-El campo estaArrendado modificado a YES";

		}
		return resultado;

	} 

}
